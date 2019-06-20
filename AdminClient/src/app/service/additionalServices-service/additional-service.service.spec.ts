import { TestBed } from '@angular/core/testing';

import { AdditionalServiceService } from './additional-service.service';

describe('AdditionalServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdditionalServiceService = TestBed.get(AdditionalServiceService);
    expect(service).toBeTruthy();
  });
});
