import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CreateUserDto } from 'src/app/model/create-user-dto';
import { AuthService } from 'src/app/services/auth.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  @Output() registerButtonClicked = new EventEmitter<void>();

  username!: string;
  email!: string;
  password!: string;
  role: string = "USER";

  constructor(
    private authService: AuthService,
    private tokenService: TokenService,
    private toast: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    
  }

  onRegister(): void{
    const dto = new CreateUserDto(this.username, this.email, this.password, this.role);
    this.authService.register(dto).subscribe({
      next: (data) => {
        this.toast.success("user have been created", 'OK', {timeOut:3000, positionClass: 'toast-top-center'});
        this.router.navigate(['/login']);
        this.registerButtonClicked.emit();
      },
      error: (err: Error) => {
        this.toast.error(err.message, 'Error', {timeOut:3000, positionClass: 'toast-top-center'});
      }
    }
    );
  }

  onRegisterButtonClick() {
    this.registerButtonClicked.emit();
  }

}
