import { Injectable } from '@angular/core';

const TOKEN_KEY = 'AuthToken';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  public setToken(token: string): void{
    localStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null{
    return localStorage.getItem(TOKEN_KEY);
  }

  public logOut(): void{
    localStorage.removeItem(TOKEN_KEY);
  }

  public isLoggedIn(): boolean{
    return this.getToken() != null;
  }

  public getUsername(): string {
    if(!this.isLoggedIn()){
      return "";
    }
    
    const token = this.getToken();
    const payload = token!.split(".")[1];
    const payloadDecoded = window.atob(payload);
    const values = JSON.parse(payloadDecoded);
    return values.sub;
  }

  public getRole(): string {
    if(!this.isLoggedIn()){
      return "";
    }

    const token = this.getToken();
    const payload = token!.split(".")[1];
    const payloadDecoded = window.atob(payload);
    const values = JSON.parse(payloadDecoded);
    return values.roles.at(0);

  }
}
