import { TestBed } from '@angular/core/testing';

import { SongIdService } from './song-id.service';

describe('SongIdService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SongIdService = TestBed.get(SongIdService);
    expect(service).toBeTruthy();
  });
});
