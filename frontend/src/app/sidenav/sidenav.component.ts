import { trigger, transition, style, animate, keyframes } from '@angular/animations';
import { Component, EventEmitter, HostListener, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { navbarData } from './nav-data';
import { TokenService } from '../services/token.service';

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css'],
  animations: [
    trigger('fadeInOut', [
      transition(':enter', [
        style({opacity: 0}),
        animate('350ms',
          style({opacity:1})
        )
      ]),
      transition(':leave', [
        style({opacity: 1}),
        animate('350ms',
          style({opacity:0})
        )
      ])
    ]),
    trigger('rotate', [
      transition(':enter', [
        animate('1000ms',
          keyframes([
            style({transform: 'rotate(0deg)', offset: '0'}),
            style({transform: 'rotate(2turn)', offset: '1'})
          ])
        )
      ])
    ])
  ]
})
export class SidenavComponent implements OnInit{
  @Output() onToggleSideNav: EventEmitter<SideNavToggle> = new EventEmitter();
  collapsed = false;
  screenWidth = 0;
  navData = navbarData;
  logoutIcon = "fal fa-sign-out"
  logoutLabel = "Logout"
  logged = false;

  @HostListener('window:resize', ['$event'])
  onResize(event:any){
    this.screenWidth = window.innerWidth;
    if(this.screenWidth <= 768){
      this.collapsed = false;
      this.onToggleSideNav.emit({collapsed: this.collapsed, screenWidth: this.screenWidth});
    }
  }

  constructor(
    private tokenService: TokenService,
    private router: Router
  ){ }

  ngOnInit(): void {
      this.screenWidth = window.innerWidth;
      if(this.tokenService.getToken() != null){
        this.logged = true;
      } else{
        this.logged = false;
      }
  }

  toggleCollapse():void {
    this.collapsed = !this.collapsed;
    this.onToggleSideNav.emit({collapsed: this.collapsed, screenWidth: this.screenWidth});
  }

  closeSidenav(): void {
    this.collapsed = false;
    this.onToggleSideNav.emit({collapsed: this.collapsed, screenWidth: this.screenWidth});
  }

  logOut(): void {
    Swal.fire({
      title: 'Do you want to logout?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonText: 'Yes, I want to logout',
      cancelButtonText: 'No, Continue in Royal Fantasy'
    }).then((result) => {
      if(result.value){
        this.tokenService.logOut();
        this.router.navigate(['/login']);
        this.logged = false;
        Swal.fire(
          'You have been logged out',
          'Thank you :)',
          'success'
        )
      } else if(result.dismiss === Swal.DismissReason.cancel){
        Swal.fire(
          'Cancelled',
          'Return to previous page',
          'error'
        )
      }
    })
  }
}
