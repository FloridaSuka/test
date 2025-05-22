# Zhvillimi i Sistemit Interaktiv për Llogaritjen e Statistikave të Notave në Arsimin Parauniversitar

Projekti jonë ka të bëjë me Zhvillimin e Sistemit Interaktiv për Llogaritjen e Statistikave të Notave në Arsimin Parauniversitar. Ky projekt është zhvilluar në kuadër të lëndës **Human Computer Interaction** dhe ka për qëllim krijimin e një aplikacioni për menaxhimin e statistikave të notave në arsimin parauniversitar (shkollat e mesme).

---

## Përmbledhje

Ky sistem interaktiv është dizajnuar për të ndihmuar shkollat në menaxhimin e të dhënave akademike dhe statistikave të notave, duke përfshirë informacionet e nxënësve, klasave, lëndëve, dhe periudhave mësimore. Aplikacioni mbështet role të ndryshme përdoruesish me privilegje të përshtatura për secilën kategori:

- **Admin**: Menaxhon përdoruesit, shkollat, drejtuesit, klasat, lëndët, mesuesit, mungesat, notat dhe periudhat.
- **Drejtor**: Monitoron statistikat e përgjithshme të shkollës dhe klasave.
- **Mesues**: Ka akses për të menaxhuar klasat, lëndët, notat dhe mungesat e nxënësve.
- **Nxënës**: Mund të shohë notat dhe mungesat e veta, si dhe informacionet për klasën dhe lëndët përkatëse.
- **Drejtor**: Monitoron statistikat e përgjithshme të shkollës dhe klasave.

---

## Entitetet kryesore të menaxhuara në aplikacion

- Adresa
- Drejtimi (programi shkollor)
- Drejtori
- Klasa dhe Paralelet
- Lënda dhe Mësimi
- Mesuesi
- Mungesat e Nxënësve
- Notat e Nxënësve
- Nxënësit
- Periudha mësimore
- Shkolla
- Përdoruesit dhe rolet e tyre

Çdo entitet përmban fushat e nevojshme për të siguruar një menaxhim të detajuar dhe të saktë të të dhënave shkollore.

---

## Karakteristikat kryesore

- CRUD (Krijo, Lexo, Përditëso, Fshi) për të gjitha entitetet
- Filtrime të avancuara të të dhënave
- Ndërfaqe përdoruesi e përshtatur për role të ndryshme
- Validim i plotë i të dhënave për të parandaluar gabimet
- Multi-gjuhësi (mundësi për zgjedhje ndërmjet anglishtes dhe shqipes)
- Raporte statistikore dhe analiza të notave dhe mungesave

---

## Zhvillimi

Aplikacioni është zhvilluar duke përdorur **JavaFX** për ndërfaqen grafike, me ndihmën e **SceneBuilder** për dizajnimin e skenave në FXML. Pjesa e bazës së të dhënave përdor **MySQL** për ruajtjen e qëndrueshme dhe të besueshme të informacionit.

---

## Arkitektura Teknike

Projekti përdor modelin **Model-View-Controller (MVC)**:

- **Model**: Përfaqësimi i të dhënave dhe objekteve (entiteteve)
- **View**: Skenat dhe ndërfaqet e përdoruesit krijohen në FXML
- **Controller**: Përpunon veprimet e përdoruesit dhe ndërvepron me shërbimet
- **Repository**: Përmban logjikën e lidhjes me bazën e të dhënave
- **Services**: Shtresa abstraksioni që përdor repository për manipulimin e të dhënave

Aplikacioni ndjek parimet e **Programimit Objekt-Orientuar (OOP)** për modularitet, mirëmbajtje dhe zgjerueshmëri më të lehtë.

---

## Menaxhimi i Bazës së të Dhënave

Projektit i janë aplikuar strategji migrimi për bazën e të dhënave, duke lehtësuar përditësimet dhe modifikimet e strukturës. Modeli SQL gjendet në folderin `migrations`, ku mund të konsultohet dhe përdoret për instalim të shpejtë.

---

## Kërkesat dhe Instalimi

Për të ekzekutuar aplikacionin, ju nevojitet:

- IDE që mbështet JavaFX (p.sh., IntelliJ IDEA, Eclipse, NetBeans)
- JDK 11 ose më i lartë
- Bibliotekat shtesë:
    - **FontAwesome** për ikonat në JavaFX
    - **JFoenix** për komponentë modern të ndërfaqes

### Udhëzime për fillim

1. Klono këtë repository në kompjuterin tuaj.
2. Hapni projektin në IDE-në tuaj.
3. Sigurohuni që bibliotekat FontAwesome dhe JFoenix të jenë të përfshira në dependencies.
4. Ndërtoni dhe ekzekutoni aplikacionin nga klasa kryesore.

---

## Kontributorët

- Diella Kika
- Florida Suka
- Florjete Kuka
- Leona Zullufi
- Gresa Daqi





