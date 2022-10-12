import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Experiencia } from '../models/experiencia';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {
  URLexp = environment.URL + 'experiencia';

  constructor(private httpx: HttpClient) { }

  public lista(): Observable<Experiencia[]> {
    return this.httpx.get<Experiencia[]>(this.URLexp + '/lista');
  }

  public detail(id: number): Observable<Experiencia> {
    return this.httpx.get<Experiencia>(this.URLexp + `/detail/${id}`);
  }

  public save(experiencia: Experiencia): Observable<any> {
    return this.httpx.post<any>(this.URLexp + '/create', experiencia);
  }

  public update(id: number, experiencia: Experiencia): Observable<any> {
    return this.httpx.put<any>(this.URLexp + `/update/${id}`, experiencia);
  }

  public delete(id: number): Observable<any> {
    return this.httpx.delete<any>(this.URLexp + `/delete/${id}`);
  }
}
