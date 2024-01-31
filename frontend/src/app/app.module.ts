import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './home/home.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { BodyComponent } from './body/body.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { PlayerInterceptor } from './interceptors/player.interceptor';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { ToastrModule } from 'ngx-toastr';
import { CreatePlayerComponent } from './player/create-player/create-player.component';
import { DetailPlayerComponent } from './player/detail-player/detail-player.component';
import { ListPlayerComponent } from './player/list-player/list-player.component';
import { UpdatePlayerComponent } from './player/update-player/update-player.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    SidenavComponent,
    BodyComponent,
    CreatePlayerComponent,
    DetailPlayerComponent,
    ListPlayerComponent,
    UpdatePlayerComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    ToastrModule.forRoot(),
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: PlayerInterceptor, multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
