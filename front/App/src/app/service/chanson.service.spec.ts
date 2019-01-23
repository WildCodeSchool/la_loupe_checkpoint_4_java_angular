import { TestBed } from '@angular/core/testing';

import { ChansonService } from './chanson.service';

describe('ChansonService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ChansonService = TestBed.get(ChansonService);
    expect(service).toBeTruthy();
  });
});
