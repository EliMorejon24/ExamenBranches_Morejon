package com.banquito.core.branches;

import com.banquito.core.branches.model.Branch;
import com.banquito.core.branches.repository.BranchRepository;
import com.banquito.core.branches.service.BranchService;
import com.banquito.core.branches.exception.CRUDException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BranchServiceTest {

	@Mock
	private BranchRepository branchRepository;

	@InjectMocks
	private BranchService branchService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAll() {
		// Mocking the repository response
		List<Branch> branches = new ArrayList<>();
		//branches.add(new Branch("branch1", "Branch 1"));
		//branches.add(new Branch("branch2", "Branch 2"));
		when(branchRepository.findAll()).thenReturn(branches);

		// Calling the service method
		List<Branch> result = branchService.getAll();

		// Verifying the result
		assertEquals(2, result.size());
		assertEquals("branch1", result.get(0).getCode());
		assertEquals("Branch 1", result.get(0).getName());
		assertEquals("branch2", result.get(1).getCode());
		assertEquals("Branch 2", result.get(1).getName());

		// Verifying that the repository method was called
		verify(branchRepository, times(1)).findAll();
		verifyNoMoreInteractions(branchRepository);
	}
}

