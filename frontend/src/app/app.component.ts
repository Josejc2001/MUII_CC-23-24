import { Component } from '@angular/core';
import { TokenService } from './services/token.service';

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend-Royal Fantasy';

  isSideNavCollapsed = false;
  screenWidth = 0;

  account: boolean = true;

  constructor(
    private tokenService: TokenService
  ) { }

  onToggleSideNav(data : SideNavToggle): void {
    this.screenWidth = data.screenWidth;
    this.isSideNavCollapsed = data.collapsed;
  }

  isLoggedIn(): boolean {
    return this.tokenService.isLoggedIn();
  }

  onLoginButtonClicked() {
    this.account = false;
  }

  onRegisterButtonCliked(){
    this.account = true;
  }
}
