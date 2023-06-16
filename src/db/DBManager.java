package db;

import java.util.ArrayList;
import java.util.List;
import models.Phone;

public class DBManager {

  static List<Phone> phones = new ArrayList<>();

  private static Long id = 5L;

  static {
    phones.add(new Phone(1L, "IPhone X", 300000, "32gb"));
    phones.add(new Phone(2L, "Samsung s20", 400000, "64gb"));
    phones.add(new Phone(3L, "XIOAMI", 500000, "128gb"));
    phones.add(new Phone(4L, "NOKIA", 9999999, "512gb"));
  }

  public static List<Phone> getPhones() {
    return phones;
  }

  public static void addPhone(Phone phone) {
    phone.setId(id);
    id++;
    phones.add(phone);
  }

  public static Phone getPhoneById(Long id) {
    return phones.stream()
        .filter(phone -> phone.getId() == id)
        .findFirst()
        .orElseThrow(null);
  }

  public static void deletePhoneById(Long id) {
//    Phone phone = getPhoneById(id);
//    if (phone != null) {
//      phones.remove(phone);
//    }
    phones.removeIf(phone -> phone.getId() == id);
  }
}
