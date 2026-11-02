# Hospital Management System - Projekt 1

## Struktur der Anwendung
Wir haben das Projekt nach der MVC-Architektur in 4 Pakete aufgeteilt:
- **model**: Enthält die Klassen aus dem UML-Diagramm (`Hospital`, `Department`, `Room`, `Patient`, `Appointment`, `MedicalStaffAppointment`) und die Vererbung für das Personal (`MedicalStaff` -> `Doctor`, `Nurse`).
- **repository**: Für jede Entität gibt es ein eigenes Repository. Die Daten werden in einer `ArrayList` im Speicher (In-Memory) verwaltet, mit den Methoden `save`, `findAll`, `findById` und `delete`.
- **service**: Jede Hauptentität hat einen eigenen Service (Single Responsibility Principle), der das jeweilige Repository aufruft.
- **controller**: Enthält den `HelloController` zum Testen der Anwendung (`/hello`) sowie den `HospitalController`.

## Erweiterungen im Modell (Punkt 5)
Wir haben folgende neue Attribute hinzugefügt:
1. **Hospital**: `address`, `phoneNumber`
2. **Patient**: `birthDate` (`LocalDate`), `bloodType`
3. **Doctor**: `specialization`, `yearsOfExperience`
