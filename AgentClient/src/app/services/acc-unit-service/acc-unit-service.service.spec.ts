import { TestBed } from '@angular/core/testing';

import { AccUnitServiceService } from './acc-unit-service.service';

describe('AccUnitServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AccUnitServiceService = TestBed.get(AccUnitServiceService);
    expect(service).toBeTruthy();
  });
});
