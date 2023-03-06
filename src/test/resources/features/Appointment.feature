#Author: Christian Maury
@Appointment
Feature: Appointment Management
  I want to manage the appointments for different clients

  @addNewAppointment
  Scenario Outline: add new appointment
    Given I enter to the main page
    When register a new appoinment
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |
    Then it should appear the new register on the right
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |

    Examples: 
      | petName | ownerName | date       | time  | symptoms             |
      | Rex     | John      | 13-06-2023 | 10:00 | fever,cough,stomache |

  @addSameAppointment
  Scenario Outline: add second appointment with the same data
    Given I enter to the main page
    When register a new appoinment
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |
    And register again the same appoinment
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |
    Then it should not allow registering a duplicated record
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |

    Examples: 
      | petName | ownerName | date       | time  | symptoms             |
      | Rex     | John      | 13-06-2023 | 10:00 | fever,cough,stomache |

  @addAppointmentPastDate
  Scenario Outline: add appointment with the past date
    Given I enter to the main page
    When register a new appoinment
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |
    Then it should not appear the new register on the right
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |

    Examples: 
      | petName | ownerName | date       | time  | symptoms             |
      | Taz     | Jack      | 02-02-2023 | 10:00 | fever,cough,stomache |

  @addAppointmentOutWrkHours
  Scenario Outline: add appointment out of working hours
    Given I enter to the main page
    When register a new appoinment
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |
    Then it should not appear the new register on the right
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |

    Examples: 
      | petName | ownerName | date       | time  | symptoms             |
      | Pops    | Rick      | 13-06-2023 | 03:00 | fever,cough,stomache |

  @deleteAppointment
  Scenario Outline: delete appointment
    Given I enter to the main page
    When register a new appoinment
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |
    And delete an appoinment
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |
    Then it should dissapear the register on the right
      | petName   | ownerName   | date   | time   | symptoms   |
      | <petName> | <ownerName> | <date> | <time> | <symptoms> |

    Examples: 
      | petName | ownerName | date       | time  | symptoms             |
      | Rex     | John      | 13-06-2023 | 10:00 | fever,cough,stomache |
