import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Musique } from '../models/musique';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  private url: string = environment.domain + 'musics/';

  private _http: HttpClient;

  constructor(param_service:HttpClient) { 
    this._http = param_service;
  }

  //Get all musics
  public GetMusics(): Observable<Musique[]> {
    return this._http.get(this.url)
      .pipe(
        map(
          (data:any) => {
            return data as Musique[];
          }
        )
      );
  }

  // Get a music with its id
  public getMusic(id: number): Observable<Musique>{
    return this._http.get(this.url + id.toString())
      .pipe(
        map(
          (data: any) => {
            return data as Musique;
          }
        )
      );
  }

  // Post a music
  public createMusic(music: Musique): Observable<Object> {
    return this._http.post(this.url, music);
  }

  // Put a music with its id
  public updateMusic(id: number, music: Musique): Observable<Object> {
    return this._http.put(this.url + id.toString(), music);
  }

  // Delete a music with its id
  public deleteMusic(id: number): Observable<Object> {
    return this._http.delete(this.url + id.toString());
  }
}
