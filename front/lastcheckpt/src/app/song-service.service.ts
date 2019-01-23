import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Song } from './song';

@Injectable({
  providedIn: 'root'
})
export class SongServiceService {

  private baseUrl = 'http://localhost:8080/api';
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }


  //CRUD methods

  //Get all songs
  public getAllSongs(): Observable<Song[]> {
    return this.http.get(`${this.baseUrl}` + "/songs").pipe(
      map(
        (param: any) => {
          let myData: Song[] = param as Song[];
          return myData;
        }
      )
    )
  }

  // Method to add a song
  public addSong(newSong: Song) {
    return this.http.post(`${this.baseUrl}/song`, newSong);
  }

  // Method to update a song
  public updateSongFromDB(id: number, song: Song) {
    return this.http.put(`${this.baseUrl}/song/${id}`, song);
  }

  // Method to delete a song
  public deleteSongFromDB(id: number) {
    return this.http.delete(`${this.baseUrl}/song/${id}`);
  }

  
}
