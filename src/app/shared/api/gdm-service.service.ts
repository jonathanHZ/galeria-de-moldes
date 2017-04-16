import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Molde } from '../domain/molde';

@Injectable()
export class GdmServiceService {

  api: String = environment.gdmApi;

  constructor(private http: Http) { }

  getMoldes(): Observable<Array<Molde>> {
    return this.http.get(this.api.concat('moldes'))
      .map((molde) => {;
        return molde.json();
      })
      .catch(this.handleError);
  }

  private handleError(error: any) {
    const errMsg = (error.message) ? error.message : error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    return Observable.throw(errMsg);
  }
}
