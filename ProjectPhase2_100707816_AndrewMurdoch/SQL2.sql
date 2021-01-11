
--a)
select avg(date_part('year', age("DateOfBirth"))) as "Average Age"
from "Actor"

--b)
select count(*) as "Number of Countries"
from (select "Country"
from "Movie" natural join "ActsIn" natural join "Actor" natural join "Location"
where "Title" = 'The Dark Knight' -- The Dark Knight instead of Beautiful Mind
group by "Country") as countries

--c)
select Count("EyeColour") as "Number of Actors"
from "Actor"
group by "EyeColour" having "EyeColour" = 'green'

--d)
select Count(*) as "Number of Movies"
from "ActsIn" natural join "Actor"
where "Name" = 'Andrew Murdoch'  -- Andrew Murdoch instead of Brad Pitt

--e)
select "Genre", 
min("Budget")::money, 
avg("Budget")::money, 
max("Budget")::money
from "Movie" natural join "Genres"
group by "Genre"

--f)
select "MovieID", "Rating" 
from (select * 
from "Actor" left join "Location" on "LocationBirthID" = "LocationID"
where "EyeColour" = 'blue' or "City" = 'Toronto') as subq natural join "ActsIn" natural join "Movie"
group by "MovieID", "Rating"

--g)
select "MovieID" 
from (select "MovieID", "Country"
from "Movie" natural join "ActsIn" natural join "Actor" left join "Location" on "LocationBirthID" = "LocationID"
group by "MovieID", "Country") as subq 
group by "MovieID" having Count("Country") > 1


--h)
select "MovieID", "Title", count("AwardID") as "Num of Awards"
from "Awards" natural join "Movie"
group by "MovieID", "Title"
order by count("AwardID") desc