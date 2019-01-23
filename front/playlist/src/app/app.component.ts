import { Component, OnInit } from "@angular/core";
import { Playlist } from "./playlist";
import { PlaylistService } from "./playlist.service";
import { FileUploadService } from "./file-upload.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "playlist";
  public playlist: Playlist[];
  private playService: PlaylistService;
  public newChan: Playlist;
  public updateChan;
  public playlistById;
  public Id: number;

  // partie envoie de fichier
  private uploadService: FileUploadService;
  public currentFile: File;

  constructor(
    param_service: PlaylistService,
    param_service_upload: FileUploadService
  ) {
    this.playService = param_service;
    this.uploadService = param_service_upload;
    this.Id = 0;
    this.newChan = { name: "", artist: "", album: "", img: "" };
    this.updateChan = { name: "", artist: "", album: "", img: "" };
    this.playlistById = { name: "", artist: "", album: "", img: "" };
  }

  ngOnInit() {
    this.playService.getPlayl().subscribe((param_play: Playlist[]) => {
      this.playlist = param_play;
    });
  }

  public create(): void {
    if (
      this.newChan.name == "" ||
      this.newChan.artist == "" ||
      this.newChan.album == "" ||
      this.newChan.img == ""
    ) {
      alert("Merci de bien vouloir remplir les champs demandés.");
    } else {
      this.doUpload();
      this.playService.addChan(this.newChan).subscribe((data: Playlist) => {
        this.ngOnInit();
        // on vide la variable
        this.newChan = { name: "", artist: "", album: "", img: "" };
      });
    }
  }

  public getUpdate(p_id): void {
    this.playService.getById(p_id).subscribe((listbyid: Playlist) => {
      this.playlistById = listbyid;
    });
  }

  public putUpdate(p_chan: Playlist, p_id): void {
    if (this.newChan.img != "") {
      this.doUpload();
      this.updateChan.img = this.newChan.img;
      this.playService.editChan(p_id, p_chan).subscribe((data: Playlist) => {
        this.ngOnInit();
        // on vide les variables
        this.updateChan = { name: "", artist: "", album: "", img: "" };
        this.newChan.img = "";
      });
    }
    this.playService.editChan(p_id, p_chan).subscribe((data: Playlist) => {
      this.ngOnInit();
      // on vide la variable
      this.updateChan = { name: "", artist: "", album: "", img: "" };
    });
  }

  // ont stock ip a supprimer
  public id(current_id): void {
    this.Id = current_id.id;
  }
  public delete(p_chan): void {
    this.playService.deleteChan(p_chan).subscribe((data: boolean) => {
      this.ngOnInit();
      // on vide la variable
      this.Id = 0;
    });
  }

  // fonction envoie de fichier
  public doUpload() {
    this.uploadService.upload(this.currentFile).subscribe((data: any) => {
      console.log(data);
    });
  }

  public onFileChange(param_event): void {
    const files: FileList = param_event.target.files as FileList;
    if (files.length > 0) {
      this.currentFile = files[0];
      this.newChan.img = "assets/" + this.currentFile.name;
    }
  }
}
