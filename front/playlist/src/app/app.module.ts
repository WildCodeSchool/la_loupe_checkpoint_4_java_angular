import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import { PlaylistService } from "./playlist.service";
import { HttpClientModule } from "@angular/common/http";
import { CommonModule } from "@angular/common";
import { FileUploadService } from "./file-upload.service";

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, CommonModule],
  providers: [PlaylistService, FileUploadService],
  bootstrap: [AppComponent]
})
export class AppModule {}