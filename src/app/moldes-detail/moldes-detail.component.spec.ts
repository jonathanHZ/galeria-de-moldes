import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoldesDetailComponent } from './moldes-detail.component';

describe('MoldesDetailComponent', () => {
  let component: MoldesDetailComponent;
  let fixture: ComponentFixture<MoldesDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoldesDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoldesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
