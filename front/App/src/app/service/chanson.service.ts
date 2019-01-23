import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Chanson } from '../entites/chanson';

@Injectable({
  providedIn: 'root'
})
export class ChansonService {

  private http: HttpClient;
  private url = 'http://localhost:8080/chanson/';

  constructor(param: HttpClient) {
    this.http = param;
  }

  public getAll() {
    return this.http.get(this.url);
  }

  public getById(id: number) {
    return this.http.get(this.url + id);
  }

  public add(chanson: Chanson) {
    return this.http.post(this.url, chanson);
  }

  public delete(id: number) {
    return this.http.delete(this.url + id);
  }

  public update(id: number, chanson: Chanson) {
    return this.http.put(this.url + id, chanson);
  }
}
