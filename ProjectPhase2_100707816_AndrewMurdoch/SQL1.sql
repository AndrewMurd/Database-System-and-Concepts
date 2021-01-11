--a)
select * 
from "Director" inner join "Location" on "LocationBirthID" = "LocationID"
where "Country" = 'Canada'

--b)
select "MovieID"
from "DirectorsIn" natural join "Director"
where "Name" = 'David Lynch'

--c) 
select distinct("ActorID") as "Actors", 
"Budget"::numeric::money as "USD",
"Budget" * 1.29::numeric::money as "CAD", 
"Budget" * 104.455::numeric::money as "JPY", 
"Budget" * 75.1166::numeric::money as "RUB", 
"Budget" * 0.824834::numeric::money as "EUR", 
"Budget" * 0.893815::numeric::money as "CHF"
from "ActsIn" natural join "Movie"
where "Budget" > 1000000

--d)
select *
from "Director"
where "Name" like 'D%' or "Name" like 'A%'

--e)
select "MovieID", "Genre"
from (select "MovieID", date_part('year', age("DateOfBirth")) as age, "Genre"
from (select *
from "Movie" natural join "Genres"
where "Genre" = 'Comedy') as subq natural join "ActsIn" natural join "Actor") as subq1
where "age" < 40

--f)
select "T1"."Name" as "First Actor", "T2"."Name" as "Second Actor", "T1"."EyeColour" as "Eye Colour"
from "Actor" "T1", "Actor" "T2"
where "T1"."EyeColour" = 'blue' and "T2"."EyeColour" = 'blue' and "T1"."Name" <> "T2"."Name"
