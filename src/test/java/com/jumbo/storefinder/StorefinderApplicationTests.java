package com.jumbo.storefinder;

import com.jumbo.storefinder.constants.StoreFinderConstants;
import com.jumbo.storefinder.model.Store;
import com.jumbo.storefinder.services.StoresFinderService;
import com.jumbo.storefinder.validation.StoreFinderRequestValidation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class StorefinderApplicationTests {

	@Autowired
	StoresFinderService storesFinderService;

	@Autowired
	StoreFinderRequestValidation storeFinderRequestValidation;


	@Test
	void testValidationRegexWorksWithStoresLatitudesAndLongitudes() {
		List<Store> stores =storesFinderService.getStoresByCoordinates(1,1);
		int i = 0;
		for(Store s : stores){
			try{
				storeFinderRequestValidation.validate(s.getLatitude(), s.getLongitude());
			} catch (Exception e){
				i++;
			}
		}
		assertEquals(0,i);
	}

	@Test
	void testValidationRegexRejectsLetters() {
		List<Store> stores =storesFinderService.getStoresByCoordinates(1,1);
		int i = 0;
			try{
				storeFinderRequestValidation.validate("a", "a");
			} catch (Exception e){
				i++;
			}
		try{
			storeFinderRequestValidation.validate("1", "a");
		} catch (Exception e){
			i++;
		}
		try{
			storeFinderRequestValidation.validate("a", "1");
		} catch (Exception e){
			i++;
		}
		assertEquals(3,i);
	}

	@Test
	void testValidationRegexRejectsSpecialCharacters() {
		List<Store> stores =storesFinderService.getStoresByCoordinates(1,1);
		int i = 0;
		try{
			storeFinderRequestValidation.validate("<.121321", "!!!!");
		} catch (Exception e){
			i++;
		}
		try{
			storeFinderRequestValidation.validate("1", "!.03249");
		} catch (Exception e){
			i++;
		}
		try{
			storeFinderRequestValidation.validate("<180.12332", "1");
		} catch (Exception e){
			i++;
		}
		assertEquals(3,i);
	}

	@Test
	void testValidationRegexRejectsEmpty() {
		int i = 0;
		try{
			storeFinderRequestValidation.validate("", "1");
		} catch (Exception e){
			i++;
		}
		try{
			storeFinderRequestValidation.validate("1", "");
		} catch (Exception e){
			i++;
		}
		try{
			storeFinderRequestValidation.validate("", "");
		} catch (Exception e){
			i++;
		}
		assertEquals(3,i);
	}

	@Test
	void testResultReturnsMaxResultsQuantity() {
		List<Store> stores =storesFinderService.getStoresByCoordinates(1,1);
		assertEquals(stores.size(),StoreFinderConstants.MAX_RESULTS);
	}

	@Test
	void testWhenSearchingForStoreCoordinatesStoreIsFirstResult() {
		//if I use the coordinates of an actual store then it should be included in the first position since is the closest to itself
		List<Store> stores =storesFinderService.getStoresByCoordinates(50.989282,5.768530);
		assertEquals(stores.get(0).getUuid(),"udsKYx4X4RgAAAFILHUYwKxK");
		stores =storesFinderService.getStoresByCoordinates(52.095381,5.129767);
		assertEquals(stores.get(0).getUuid(),"sWwKYx4XRAsAAAFIJoIYwKxK");
	}

	@Test
	void testResultsAreSorted() {
		List<Store> stores =storesFinderService.getStoresByCoordinates(50.989282,5.768530);
		assertTrue(stores.get(0).getDistance() <= stores.get(1).getDistance());
		assertTrue(stores.get(1).getDistance() <= stores.get(2).getDistance());
		assertTrue(stores.get(2).getDistance() <= stores.get(3).getDistance());
		assertTrue(stores.get(3).getDistance() <= stores.get(4).getDistance());
	}

}
