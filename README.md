# 🏪 AI Inventory Optimizer

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-green)
![Status](https://img.shields.io/badge/Status-Production%20Ready-brightgreen)

AI-powered inventory optimization system using Claude AI. Analyzes retail store inventory in real-time, identifies overstock/understock situations, and provides actionable recommendations to improve cash flow and prevent lost sales.

**Live Demo:**
carefree-respect-production-0290.up.railway.app
---

## 🎯 **Features**

- ✅ **Real-Time Inventory Analysis** - Analyze multiple store inventories simultaneously
- ✅ **Overstock Detection** - Identify excess inventory tying up working capital
- ✅ **Understock Prevention** - Prevent stock-outs and lost sales
- ✅ **Markdown Recommendations** - Suggest optimal pricing for clearance
- ✅ **Financial Impact Calculation** - Quantify potential savings and revenue
- ✅ **Multi-Store Dashboard** - View analysis across multiple locations
- ✅ **Interactive UI** - Beautiful, responsive web interface
- ✅ **REST APIs** - Built-in APIs for external integrations

---

## 💼 **Business Impact**

For a retail chain like Walmart (4,700+ stores):

| Metric | Impact |
|--------|--------|
| **Overstock Reduction** | 20-30% = $1-3B working capital freed |
| **Stock-Out Prevention** | 25-40% = $500M-1B additional sales |
| **Markdown Optimization** | 5-10% = $50-100M profit improvement |
| **Total Annual Impact** | **$1.5-4.5B** |

---

## 🛠️ **Tech Stack**

### **Backend**
- **Language:** Java 17 (LTS)
- **Framework:** Spring Boot 3.1.0
- **Web:** Spring MVC
- **Templating:** Thymeleaf
- **Database:** H2 (in-memory for demo)
- **Build:** Maven 3.8+
- **Libraries:** Lombok (reduce boilerplate)

### **Frontend**
- **HTML5** - Semantic markup
- **CSS3** - Responsive design
- **JavaScript** - Vanilla JS (no frameworks)
- **Bootstrap-free** - Custom CSS

### **DevOps**
- **Containerization:** Docker
- **Deployment:** Railway.app
- **Version Control:** Git & GitHub
- **CI/CD:** Railway auto-deploy

### **Architecture**
- **Pattern:** MVC (Model-View-Controller)
- **Design:** Layered Architecture
- **APIs:** RESTful endpoints
- **Data Flow:** Controller → Service → Model

---

## 📊 **Project Structure**
ai-inventory-optimizer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/inventory/
│   │   │       ├── InventoryApp.java
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── model/
│   │   │       └── data/
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── templates/
│   │       └── static/
│   └── test/
├── target/                    
├── pom.xml
├── README.md
└── .gitignore