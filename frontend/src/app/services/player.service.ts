import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Player } from '../model/player';

const headers = new HttpHeaders({
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': 'http://localhost:4200',
  'Access-Control-Allow-Methods': 'DELETE' // Asegúrate de incluir DELETE en los métodos permitidos
});

@Injectable({
  providedIn: 'root'
})

export class PlayerService {

  playerURL = environment.apiRestURL + '/api/players'

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Object>{
    return this.httpClient.get<Object>(this.playerURL);
  }

  public detail(id: string): Observable<Player>{
    return this.httpClient.get<Player>(this.playerURL + `/${id}`);
  }

  public create(product: Player): Observable<any>{
    return this.httpClient.post<any>(this.playerURL, product);
  }

  public update(id: string, product: Player): Observable<any>{
    return this.httpClient.patch<any>(this.playerURL + `/${id}`, product);
  }

  public delete(id: string): Observable<any>{
    return this.httpClient.delete<any>(this.playerURL + `/${id}`, {headers});
  }
}