document.getElementById("studentData").addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const studentData = {
        name: formData.get("name"),
        contact: formData.get("contact"),
        address: formData.get("address"),
        gmail: formData.get("gmail"),
        admission: formData.get("admission"),
        branch: formData.get("branch"),
        date: formData.get("dates"),
        admissionType: formData.get("admissionType"),   // ✅ match Java field
        category: formData.get("category"),
        studentClass: formData.get("studentClass"),            // ✅ match Java field
        parentsContact: formData.get("parentsContact"),  // ✅ match Java field
        occupation: formData.get("occupation"),
        parentname: formData.get("parentname"),         // ✅ match Java field
    };

    fetch("http://localhost:8080/students", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify([studentData]), // Your backend expects a List<Student>
    })
    .then((response) => {
        if (!response.ok) throw new Error("Network response was not ok");
        return response.json();
    })
    .then((data) => {
        alert("Student registered successfully");
        document.getElementById("studentData").reset(); // Clear form
        console.log(data);
    })
    .catch((error) => {
        console.error("Error:", error);
        alert("Registration failed");
    });
});
