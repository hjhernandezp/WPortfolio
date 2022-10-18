import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Estudios } from '../models/estudios';

@Injectable({
  providedIn: 'root'
})
export class EstudiosService {
  URLest = environment.URL + '/estudios';

  constructor(private httpx: HttpClient) { }

  public lista(): Observable<Estudios[]> {
    return this.httpx.get<Estudios[]>(this.URLest + '/lista');
  }

  public detail(id: number): Observable<Estudios> {
    return this.httpx.get<Estudios>(this.URLest + `/detail/${id}`);
  }

  public save(estudios: Estudios): Observable<any> {
    return this.httpx.post<any>(this.URLest + '/create', estudios);
  }

  public update(id: number, estudios: Estudios): Observable<any> {
    return this.httpx.put<any>(this.URLest + `/update/${id}`, estudios);
  }

  public delete(id: number): Observable<any> {
    return this.httpx.delete<any>(this.URLest + `/delete/${id}`);
  }
}
