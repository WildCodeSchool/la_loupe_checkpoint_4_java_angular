import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Playlist } from '../model/playlist';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private baseUrl = 'http://localhost:8080/playlists';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient ) {
  }

  getPlaylists(): Observable<Playlist[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data as Playlist[])
    );
  }

  getPlaylist(id: number): Observable<Playlist> {
    return this.http.get<Playlist>(`${this.baseUrl}/${id}`);
  }

  createPlaylist(playlist: Playlist): Observable<Playlist> {
    return this.http.post<Playlist>(this.baseUrl, playlist, {headers: this.httpHeaders});
  }

  updatePlaylist(playlist: Playlist): Observable<Playlist> {
    return this.http.put<Playlist>(this.baseUrl, playlist, {headers: this.httpHeaders});
  }

  deletePlaylist(id: number): Observable<Playlist> {
    return this.http.delete<Playlist>(`${this.baseUrl}/${id}`, {headers: this.httpHeaders});
  }
}
