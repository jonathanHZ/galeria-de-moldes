import { TestBed, inject } from '@angular/core/testing';

import { GdmServiceService } from './gdm-service.service';

describe('GdmServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GdmServiceService]
    });
  });

  it('should ...', inject([GdmServiceService], (service: GdmServiceService) => {
    expect(service).toBeTruthy();
  }));
});
