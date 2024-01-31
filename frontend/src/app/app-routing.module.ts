import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './home/home.component';
import { ListPlayerComponent } from './player/list-player/list-player.component';
import { DetailPlayerComponent } from './player/detail-player/detail-player.component';
import { UpdatePlayerComponent } from './player/update-player/update-player.component';
import { CreatePlayerComponent } from './player/create-player/create-player.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'players', component: ListPlayerComponent },
  { path: 'detail/:id', component: DetailPlayerComponent },
  { path: 'update/:id', component: UpdatePlayerComponent },
  { path: 'createPlayer', component: CreatePlayerComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }