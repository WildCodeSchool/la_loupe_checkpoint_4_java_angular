import { Component, OnInit } from '@angular/core';

import { SongService} from 'src/app/services/song.service';
import { Song } from 'src/app/models/song';

@Component({
	selector: 'app-create-song',
	templateUrl: './create-song.component.html',
	styleUrls: ['./create-song.component.css']
})
export class CreateSongComponent implements OnInit {

	public newSong: Song = new Song();

	constructor(private songService: SongService) { }

	ngOnInit() {
	}

    public createArticle(param_name, param_artist, param_album, param_image): void {
        this.newSong.name = param_name;
        this.newSong.artist = param_artist;
		this.newSong.album = param_album;
		this.newSong.img = param_image;

		this.songService.addSong(this.newSong).subscribe( 
			// (data) => {
			// 	console.log("POST call successful value returned in body", 
			// 				data);
			// },
			// response => {
			// 	console.log("POST call in error", response);
			// },
			// () => {
			// 	console.log("The POST observable is now completed.");
			//}
			);
	}
}
