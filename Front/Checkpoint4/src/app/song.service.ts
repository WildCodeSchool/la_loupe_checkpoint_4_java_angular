import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Song } from './song';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  private url: string;
  private songs: HttpClient;

  constructor(param_service: HttpClient) {
    this.songs = param_service;
    this.url = environment.domain + "songs/";
  }

  public getSongs(): Observable<Song[]> {
    return this.songs.get(this.url).pipe(
      map(
        (param_data: any) => {
          return param_data as Song[];
        }
      )
    );
  }

  public addSong(param_song: Song): Observable<Song> {
    return this.songs.post(this.url, param_song).pipe(
      map(
        (param_response: any) => {
          return param_response as Song;
        }
      )
    );
  }

  public editSong(p_id: number, p_song: Song): Observable<Song> {

    return this.songs.put(this.url + p_id, p_song).pipe(
      map(
        (param_response: any) => {
          return param_response as Song;
        }
      )
    );
  }

  public deleteSong(param_id: number): Observable<boolean> {
    return this.songs.delete(this.url + param_id).pipe(
      map(
        (param_response: any) => {
          return param_response as boolean;
        }
      )
    );
  }

  public addImg(param: FormData) {
    const url = environment.domain + "/songs/uploadImage";
    return this.songs.post(url, param);
  }
}
