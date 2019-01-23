import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { Song } from '../components/models/Song';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  private url: string = environment.domain;

  private http: HttpClient;
  constructor(p_http: HttpClient) { 
    this.http = p_http;
  }

  // List all songs
  public listAllSongs(): Observable<Song[]> {
    return this.http.get(this.url + '/songs')
      .pipe(
        map(
          (data: any) => {
            return data as Song[];
          }
        )
      )
  }

  // Add a song
  public addSong(p_song: Song): Observable<Object> {
    return this.http.post(this.url + '/song/', p_song);
  }

  // Delete a song
  public deleteSong(p_id: string): Observable<Object> {
    return this.http.delete(this.url + '/song/' + p_id.toString());
  }

}
