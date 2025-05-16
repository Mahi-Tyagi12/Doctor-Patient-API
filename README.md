# Doctor-Patient API Platform

## 📄 Description
This project manages doctor and patient information, providing functionalities such as adding doctors/patients and suggesting doctors based on patient symptoms.

## 🛠️ Technologies Used
- Java
- Maven
- Spring Boot
- Postman

## 🚀 Setup Instructions
Clone the repository:
git clone https://github.com/Mahi-Tyagi12/Doctor-Patient-API
Navigate to the project directory:
cd XceloreDoctorPatientAPI
Build the project:
mvn clean install
Run the application:
mvn spring-boot: run

📬 API Endpoints
POST /addDoctor:
Add a new doctor.

POST /addPatient:
Add a new patient.

GET /suggestDoctor/{patientId}: 
Suggest doctors based on patient ID.

📂 Postman Collection
The Postman collection used for testing the APIs is included in the repository as XceloreDoctorPatientAPI.postman_collection.json.

🖼️ API Request and Response Screenshots
![get_patients](https://github.com/user-attachments/assets/fb9302ac-1443-4d04-a300-c5cfc058b801)
![get_doctrors](https://github.com/user-attachments/assets/0a51e444-cd4c-4f13-a6a0-677be411d505)
