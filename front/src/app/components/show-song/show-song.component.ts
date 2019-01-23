import { Component, OnInit } from '@angular/core';
import { SongService} from 'src/app/services/song.service';
import { SongIdService } from 'src/app/services/song-id.service';
import { Song } from 'src/app/models/song';

@Component({
	selector: 'app-show-song',
	templateUrl: './show-song.component.html',
	styleUrls: ['./show-song.component.css']
})
export class ShowSongComponent implements OnInit {

	public currentSong: Song = new Song();
	public selectedSongId: number;

	constructor(private songService: SongService, private songIdService: SongIdService) { }

	ngOnInit() {
		this.songIdService.currentSong.subscribe( param_id => this.selectedSongId = param_id);

		this.songService.getSongs().subscribe(
			(data: any) => {
				data.map( song => {
					if( this.selectedSongId == song.id){
						this.currentSong.name = song.name;
						this.currentSong.artist = song.artist;
						this.currentSong.album = song.album;
						this.currentSong.img = song.img;
					}
				})
			}
		)
	}

	//	MISE A JOUR 
	public updateSong(param_name, param_artist, param_album, param_image){
		
		this.currentSong.id = this.selectedSongId;
		this.currentSong.name = param_name;
		this.currentSong.artist = param_artist;
		this.currentSong.album = param_album;
		this.currentSong.img = param_image;

		this.songService.updateSong(this.currentSong).subscribe();
		
	}
	// SUPPRESSION
	public deleteSong(param_id): void{
		this.songService.deleteSong(param_id).subscribe();
    }
}
