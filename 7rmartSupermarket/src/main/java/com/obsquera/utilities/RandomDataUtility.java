package com.obsquera.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class RandomDataUtility {

Faker faker = new Faker();

public String togetFirstname() {
return (faker.name().firstName());
}

public String togetLastname() {
return (faker.name().lastName());

}

public String togetFullname() {
return (faker.name().fullName());

}

public String togetNamewithMiddle() {
return (faker.name().nameWithMiddle());

}

public String togetBloodgroup() {
return (faker.name().bloodGroup());

}

public String togetbuildingNumber() {
return (faker.address().buildingNumber());
}

public String togetcity() {
return (faker.address().city());
}

public String togetcityName() {
return (faker.address().cityName());
}

public String togetcountry() {
return (faker.address().country());
}

public String togetcountryCode() {
return (faker.address().countryCode());
}

public String togetcountyByZipCode(String pincode) {
return (faker.address().countyByZipCode(pincode));
}

public String togetlatitude() {
return (faker.address().latitude());
}

public String togetlongitude() {
return (faker.address().longitude());
}

public String togetsecondaryAddress() {
return (faker.address().secondaryAddress());
}

public String togetstate() {
return (faker.address().state());
}

public String togetstateAbbr() {
return (faker.address().stateAbbr());
}

public String togetstreetAddress() {
return (faker.address().streetAddress());
}

public String togetstreetAddress(boolean value) {
return (faker.address().streetAddress(value));
}

public String togetstreetAddressNumber() {
return (faker.address().streetAddressNumber());
}

public String togetstreetName() {
return (faker.address().streetName());
}

public String togetstreetPrefix() {
return (faker.address().streetPrefix());
}

public String togetstreetSuffix() {
return (faker.address().streetSuffix());
}

public String togettimeZone() {
return (faker.address().timeZone());
}

public String togetzipCode() {
return (faker.address().zipCode());
}

public String togetzipCodeByState(String state) {
return (faker.address().zipCodeByState(state));
}

public String togethero() {
return (faker.ancient().hero());
}

public String togetgod() {
return (faker.ancient().god());
}

public String togetanimalname() {
return (faker.animal().name());
}

public String togetemail() {
return (faker.internet().emailAddress());
}

public String togetpass() {
return (faker.internet().password());
}

public String togetfruit() {
return (faker.food().fruit());
}

public int togetnumber(int min, int max) {
return (faker.number().numberBetween(min, max));
}

public String togetdate() {
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
String dob = sdf.format(faker.date().birthday());
return dob;
}

public String togetWebsite() {
return (faker.internet().domainSuffix());
}

public String togetPhoneNo() {
return (faker.phoneNumber().cellPhone());
}

public String togetfoodName() {
return (faker.food().dish());
}

public String togetVegetableName() {
return (faker.food().vegetable());
}

public String togetStringnumber(int num) {
return (faker.number().digits(num));
}

public String togetProductName() {
return faker.commerce().productName();
}

}

