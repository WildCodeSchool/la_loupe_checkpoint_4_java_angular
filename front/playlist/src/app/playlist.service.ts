import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Song } from './song';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private baseUrl = "http://localhost:8080/api";
  private service: HttpClient;

  constructor(p_service: HttpClient) {
    this.service = p_service;
  }


  public getAllSongs(): Observable<Song[]> {
    return this.service.get(`${this.baseUrl}/songs/`).pipe(
      map(
        (my_response) => {
          let obj: any = my_response as Song;
          return obj;
        }
      )
    )
  }

  public getSong(song_id:number):Observable<Song>{
    return this.service.get(`${this.baseUrl}/songs/${song_id}`).pipe(
      map(
        (my_response) => {
          let obj: Song = my_response as Song;
          return obj;
        }
      )
    )
  }

  public addSong(song:Song){
    return this.service.post(`${this.baseUrl}/songs/`, song);
  }

  public updateSong(song_id:number, song:Song){
    return this.service.put(`${this.baseUrl}/songs/${song_id}`, song);
  }

  public deleteSong(song_id:number){
    return this.service.delete(`${this.baseUrl}/songs/${song_id}`);
  }



}
