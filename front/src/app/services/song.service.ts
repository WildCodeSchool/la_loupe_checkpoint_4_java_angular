import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Song } from 'src/app/models/song';

import { map} from 'rxjs/operators';

@Injectable({
	providedIn: 'root'
})
export class SongService {

	public apiUrl: string = "http://localhost:8080/song";
	private serviceHttp: HttpClient;

	constructor(private param_http: HttpClient) {
		this.serviceHttp = param_http;
	}

	//  ########################### GET ( READ ALL) ###########################
	public getSongs():  Observable <Song[]>{
		return this.serviceHttp.get( this.apiUrl + "/all" ).pipe(
			map( (data: any ) => {

				console.log("eeee", data);
				console.log("eeee", data.lenght)

				data.map( song => {
					console.log(song);
				});

				return data;
			})
		)
	}
//  ########################### POST ( CREATE ) ###########################
	addSong(song: Song): Observable <Song> {
		return this.serviceHttp.post<Song>(this.apiUrl, song).pipe(
			map( (newSong: any) => {
				return newSong as Song;
			})
		);
	}

//  ########################### PUT (UPDATE) ###########################
	updateSong (song: Song): Observable<Song> {
		return this.serviceHttp.put(this.apiUrl + "/" + song.id, song).pipe(
			map( (songUpdate: any) => {
				return songUpdate as Song;
			})
		);
	} 

//  ########################### DELETE ( DELETE ) ###########################
deleteSong(id: number): Observable<Boolean>{
	return this.serviceHttp.delete( this.apiUrl + "/"+id).pipe(
		map( (data: any) => {
			return true;
		})
	)
}

}

	
