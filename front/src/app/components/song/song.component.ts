import { Component, OnInit } from '@angular/core';
import { SongService} from 'src/app/services/song.service';
import { Song } from 'src/app/models/song';
import { SongIdService } from 'src/app/services/song-id.service';

@Component({
	selector: 'app-song',
	templateUrl: './song.component.html',
	styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {

	public songsTab: Song[] = new Array();
	public selectedSongId: number;

	constructor(private songService: SongService, private songIdService: SongIdService) { }

	ngOnInit() {
		this.songIdService.currentSong.subscribe( param_id => this.selectedSongId = param_id);
		
		this.songService.getSongs().subscribe(
			(data: any) => {
				this.songsTab = data;
			}
		)
	}

	public sendSongId( param_id: number){
		console.log("selectedId", param_id)
		this.selectedSongId = param_id;
		this.songIdService.getSongId( this.selectedSongId );
	}

}
