import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoldesListComponent } from './moldes-list.component';

describe('MoldesListComponent', () => {
  let component: MoldesListComponent;
  let fixture: ComponentFixture<MoldesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoldesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoldesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
