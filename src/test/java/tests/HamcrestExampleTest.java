package tests;

import animals.AnimalType;
import animals.petstore.pet.Pet;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.PetType;
import animals.petstore.pet.attributes.Skin;
import animals.petstore.pet.types.Dog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Provide a hamcrest asserts example
 */
public class HamcrestExampleTest {
    private List<Pet> dListActual = Arrays.asList(
            new Dog(AnimalType.DOMESTIC, Skin.FUR, Gender.MALE, Breed.MALTESE,
                    new BigDecimal("750.00"), 1),
            new Dog(AnimalType.DOMESTIC, Skin.FUR, Gender.MALE, Breed.POODLE,
                    new BigDecimal("750.00"), 2),
            new Dog(AnimalType.DOMESTIC, Skin.HAIR, Gender.FEMALE, Breed.GERMAN_SHEPARD,
                    new BigDecimal("750.00"), 2)
    );

    private List<Pet> dListExpected = Arrays.asList(
            new Dog(AnimalType.DOMESTIC, Skin.FUR, Gender.MALE, Breed.MALTESE,
                    new BigDecimal("750.00"), 1),
            new Dog(AnimalType.DOMESTIC, Skin.FUR, Gender.MALE, Breed.POODLE,
                    new BigDecimal("750.00"), 2),
            new Dog(AnimalType.DOMESTIC, Skin.HAIR, Gender.FEMALE, Breed.CARDINAL,
                    new BigDecimal("750.00"), 2)
    );

    private List<Pet> dListNew = new ArrayList<>(Arrays.asList(
            new Dog(AnimalType.DOMESTIC, Skin.FUR, Gender.MALE, Breed.MALTESE,
                    new BigDecimal("750.00"), 1),
            new Dog(AnimalType.DOMESTIC, Skin.FUR, Gender.MALE, Breed.POODLE,
                    new BigDecimal("750.00"), 2),
            new Dog(AnimalType.DOMESTIC, Skin.HAIR, Gender.FEMALE, Breed.GERMAN_SHEPARD,
                    new BigDecimal("750.00"), 2)
    ));

    @Test
    @DisplayName("ABC test")
    public void abcTest()
    {
        assertThat("abc",equalToIgnoringCase("b"));
    }

    @Test
    @DisplayName("Empty String test")
    public void emptyStringTest()
    {
        assertThat(null,is(nullValue()));

    }

    @Test
    @DisplayName("Collection Test not empty")
    public void dogCollectionNotEmptyTest()
    {
        assertThat(dListActual.isEmpty(), is(false));
    }

    @Test
    @DisplayName("Collection Test not null")
    public void dogCollectionNotEmptyNotNull()
    {
        assertThat(dListActual, is(notNullValue()));
    }

    @Test
    @DisplayName("Dog Collection  Match Tests1")
    public void dogCollectionMatch()
    {
        assertThat("List equality without order",dListExpected, equalTo(dListActual)) ;
    }

    @Test
    @DisplayName("Dog Collection  Match Tests2")
    public void dogCollectionSameListTest()
    {
        assertThat("List equality without order",dListExpected, equalTo(dListExpected)) ;
    }

//------New Tests I have added to increase code coverage-----------------

    @Test
    @DisplayName("Dog Collection Not Equals")
    public void dogCollectionsNotSameTest()
    {
        assertNotEquals(dListExpected, dListActual);
    }

    @Test
    @DisplayName("PetType is DOG for all in dListActual")
    public void actualCollectionHasDogsTest()
    {
        for(Pet animal : dListActual) {
            assertEquals(PetType.DOG, animal.getPetType());
        }
    }

    @Test
    @DisplayName("New List Must Now Have A Pet Object")
    public void newListHasPetObjectTest()
    {
        Pet pet = new Dog(AnimalType.UNKNOWN, Skin.FUR, Gender.FEMALE, Breed.POODLE,
                new BigDecimal("700.00"), 4);
        dListNew.add(pet);
        assertThat("List has pet object", dListNew, hasItem(pet));
    }
}
