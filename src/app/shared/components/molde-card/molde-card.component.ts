import { Component, OnInit, Input } from '@angular/core';
import { Molde } from '../../domain/molde';

@Component({
  selector: 'app-molde-card',
  templateUrl: './molde-card.component.html',
  styleUrls: ['./molde-card.component.less']
})
export class MoldeCardComponent implements OnInit {
  @Input()  molde: Molde;
  constructor() { }

  ngOnInit() {
    console.log(this.molde);
  }

}
