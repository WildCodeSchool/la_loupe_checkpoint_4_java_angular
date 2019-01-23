import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class SongIdService {

	private selectedSong = new BehaviorSubject<number>( 0 );
	currentSong = this.selectedSong.asObservable();

	constructor() { }

	getSongId( param_id: number){
		this.selectedSong.next(param_id);
	}
}
