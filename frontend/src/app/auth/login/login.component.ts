import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { AuthService } from "src/app/services/auth.service";
import { TokenService } from "src/app/services/token.service";
import { LoginUserDto } from "../../model/login-user-dto"


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  @Output() loginButtonClicked = new EventEmitter<void>();

  username!: string;
  password!: string;

  constructor(
    private authService: AuthService,
    private tokenService: TokenService,
    private toast: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    
  }

  onLogin(): void {
    const dto = new LoginUserDto(this.username, this.password);
    this.authService.login(dto).subscribe({
      next: (data:any) => {
        this.tokenService.setToken(data.token);
        this.router.navigate(['/home']);
      },
      error: (err: Error) => {
        this.toast.error("Bad Credentials", 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
      }
    }
    );
  }

  onLoginButtonClick() {
    this.loginButtonClicked.emit();
  }


}
