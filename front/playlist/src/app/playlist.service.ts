import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators/';

import { Song } from './song';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private target: string;
  private service: HttpClient;

  constructor(p_service: HttpClient) {
    this.service = p_service;
    this.target = environment.domain + 'songs/';
  }

  public getAll(): Observable<Song[]> {
    return this.service.get(this.target).pipe(map((p_response: any) => {
      return p_response as Song[];
    }));
  }

  public getById(p_id: number): Observable<Song> {
    return this.service.get(this.target + p_id).pipe(map((p_response: any) => {
      return p_response as Song;
    }));
  }

  public addSong(p_song: Song): Observable<Song> {
    return this.service.post(this.target, p_song).pipe(map((p_response: any) => {
      return p_response as Song;
    }));
  }

  public editSong(p_id: number, p_song: Song): Observable<Song> {
    return this.service.put(this.target + p_id, p_song).pipe(map((p_response: any) => {
      return p_response as Song;
    }));
  }

  public deleteSong(p_id: number): Observable<boolean> {
    return this.service.delete(this.target + p_id).pipe(map((p_response: any) => {
      return p_response as boolean;
    }));
  }
}
