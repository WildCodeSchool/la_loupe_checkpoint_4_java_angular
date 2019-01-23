import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment.prod";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class FileUploadService {
  private HttpServiceFileUp: HttpClient;
  private target: string;

  constructor(param_service: HttpClient) {
    this.HttpServiceFileUp = param_service;
    this.target = environment.domaine + "upload/";
  }

  public upload(p_file: File): Observable<boolean> {
    const headers: HttpHeaders = new HttpHeaders();
    const data: FormData = new FormData();

    data.append("file", p_file, p_file.name);

    headers.append("Content-type", "multipart/form-data");
    const obs: Observable<boolean> = this.HttpServiceFileUp.post(
      this.target,
      data,
      { headers: headers }
    ).pipe(
      map((param_response: boolean) => {
        return param_response;
      })
    );
    return obs;
  }
}
