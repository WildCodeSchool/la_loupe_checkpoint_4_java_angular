import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Song } from '../models/song';
import { environment } from 'src/environments/environment'

@Injectable({
  providedIn: 'root'
})
export class SongsService {

  private url: string = 'http://localhost:8080/songs';

  // Inject HttpClient into the service
  private _http: HttpClient;

  constructor(param_service: HttpClient) {
    this._http = param_service;
   }

   // Get all massages
  public getSongs(): Observable<Song[]> {
    return this._http.get(this.url)
      .pipe(
        map(
          (data: any) => {
            return data as Song[];
          }
        )
      );
  }

  // Get a song with its id
  public getSong(id: number, apikey: string): Observable<Song> {
    return this._http.get(`${this.url + id.toString()}/${apikey}`)
      .pipe(
        map(
          (data: any) => {
            return data as Song;
          }
        )
      );
  }

  // Post a song
  public createSong(apikey: string, song: Song): Observable<Object> {
    return this._http.post(`${this.url}/${apikey}`, song);
  }

  // Put a song with its id
  public updateSong(id: number, apikey: string, song: Song): Observable<Object> {
    return this._http.put(`${this.url + id.toString()}/${apikey}`, song);
  }

  // Delete a song with its id
  public deleteSong(id: number, apikey: string): Observable<Object> {
    return this._http.delete(`${this.url + id.toString()}/${apikey}`);
  }
}
