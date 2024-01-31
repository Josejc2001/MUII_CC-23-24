import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html',
  styleUrls: ['./update-player.component.css']
})
export class UpdatePlayerComponent implements OnInit{

  id!: string;
  player!: Player;

  constructor(
    private playerService: PlayerService,
    private toast: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ){ }


  ngOnInit(): void {
    this.getPlayer();
  }

  onUpdate(): void {
    this.playerService.update(this.id, this.player).subscribe({
      next: () => {
        this.toast.success('Product updated successfully', 'OK', {timeOut:3000, positionClass: 'toast-top-center'});
        this.router.navigate(['/players']);
      },
      error: () => {
        this.toast.error('Failed to update a product', 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
      }
    }
    );
  }

  getPlayer(): void{
    this.id = this.activatedRoute.snapshot.params['id'];
    this.playerService.detail(this.id).subscribe({
      next: (p : Player) =>{
        this.player = p;
      } ,

      error: (err: Error) => {
        this.toast.error('No product found with that id', 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
        this.router.navigate(['']);
      }
    }
    );
  }

}
