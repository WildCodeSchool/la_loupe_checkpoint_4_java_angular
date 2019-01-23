import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, identity } from 'rxjs';
import { map } from 'rxjs/operators';
import { Songs } from "./songs";


@Injectable({
  providedIn: 'root'
})
export class SongService {

  private url: string = "http://localhost:8080/songs";

  private _http: HttpClient;

  constructor(param_service: HttpClient) { 
    this._http = param_service;
  }

  //get songs
  public getSongs(): Observable<Songs[]>{
    return this._http.get(this.url)
      .pipe(
        map(
          (data: any) => {
            return data as Songs[];
          }
        )
      );
  }


  //get with id
  public getSong(id: number): Observable<Songs>{
    return this._http.get(this.url+"/"+id.toString()).pipe(
      map(
        (data: any) => {
          return data as Songs;
        }
      )
    );
  }

  //Post song
  public createSong(song: Songs): Observable<Object>{
    return this._http.post(this.url, song);
  }

  //Put song
  public updateSong(id: number, song: Songs): Observable<Object>{
    return this._http.put(this.url+"/"+id.toString(), song);
  }

  //Delete song
  public deleteSong(id: number): Observable<Object>{
    return this._http.delete(this.url+"/"+id.toString());
  }

}
