package com.allana.submissionsatu_jetpackpro.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsDetailResponse
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsResponse

object DataDummy {

    /**
     * simulation data remote
     */
    fun generateMoviesDetailDataDummy(): List<MoviesDetailResponse> {
        val movies = ArrayList<MoviesDetailResponse>()

        movies.add(
            MoviesDetailResponse(
                1,
                "Alita: Battle Angel",
                "2019",
                "Science Fiction, Action, Adventure",
                "2h 2m",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Robert Rodriguez",
                "Laeta Kalogridis and James Cameron",
                "$170,000,000.00",
                "$404,852,543.00",
                "Rosa Salazar as Alita, Christoph Waltz as Dr. Dyson Ido, Jennifer Connelly as Chiren, Mahershala Ali as Vector, Ed Skrein as Zapan, Jackie Earle Haley as Grewishka, Keean Johnson as Hugo, Lana Condor as Koyomi, Jorge Lenderborg Jr. as Tanji",
                R.drawable.poster_alita
            )
        )
        movies.add(
            MoviesDetailResponse(
                2,
                "Aquaman",
                "2018",
                "Fantasy, Action, Adventure",
                "2h 24m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "James Wan",
                "Will Beall and David Leslie Johnson-McGoldrick",
                "$160,000,000.00",
                "$1,148,461,807.00",
                "Jason Momoa as Arthur Curry / Aquaman, Amber Heard as Mera, Willem Dafoe as Nuidis Vulko, Patrick Wilson as King Orm Marius / Ocean Master, Nicole Kidman as Atlanna, Dolph Lundgren as King Nereus, Yahya Abdul-Mateen II as David Kane / Black Manta, Temuerra Morrison as Thomas Curry, Ludi Lin as Captain Murk",
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MoviesDetailResponse(
                3,
                "Bohemian Rhapsody",
                "2018",
                "Drama, Music",
                "2h 15m",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "Bryan Singer",
                "Anthonu McCarten",
                "$52,000,000.00",
                "$894,027,543.00",
                "Rami Malek as Freddie Mercury, Gwilym Lee as Brian May, Ben Hardy as Roger Taylor, Joseph Mazzelo as John Deacon, Lucy Boynton as Mary Austin, Aidan Gillen as John Reid, Allen Leech as Paul Prenter, Tom Hollander as Jim Beach, Mike Myers as Ray Foster",
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MoviesDetailResponse(
                4,
                "Creed II",
                "2018",
                "Drama",
                "2h 10m",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "Steven Caple Jr.",
                "Sylvester Stallone and Juel Taylor",
                "$50,000,000.00",
                "$214,215,889.00",
                "Michael B. Jordan as Adonis Creed, Sylvester Stallone as Robert Balboa Sr., Dolph Lundgreen as Ivan Drago, Florian Munteanu as Viktor Drago, Tessa Thompson as Bianca Taylor, Wood Harris as Tony Evers, Phylicia Rashad as Mary Anne Creed, Andre Ward as Danny Wheeler, Brigitte Nielsen as Ludmilla Drago",
                R.drawable.poster_creed
            )
        )
        movies.add(
            MoviesDetailResponse(
                5,
                "A Star Is Born",
                "2018",
                "Drama, Romance, Music",
                "2h 16m",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "Bradley Cooper",
                "Bradley Cooper, Will Fetters, and Eric Roth",
                "$36,000,000.00",
                "$433,888,866.00",
                "Bradley Cooper as Jackson Maine, Lady Gaga as Ally Campana, Sam Elliot as Bobby Maine, Andrew Dice Clay as Lorenzo Campana, Rafi Gavron as Rez Gavron, Anthony Ramos as Ramon, Dave Chappelle as George Stone, Marlon Williams as Himself, Brandy Carlile as Herself",
                R.drawable.poster_a_start_is_born
            )
        )
        movies.add(
            MoviesDetailResponse(
                6,
                "Cold Pursuit",
                "2019",
                "Action, Crime, Thriller",
                "1h 59m",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "Hans Petter Moland",
                "Frank Baldwin",
                "$60,000,000.00",
                "$76,419,755.00",
                "Liam Neeson as Nels Coxman, Laura Dern as Grace Coxman, Emmy Rossum as Kim Dash, Michale Eklund as Steve Milliner, Micheal Richardson as Kyle Coxman, Bradley Stryker as Jacon Rutman, Tom Bateman as Trevor Calcote, Domenick Lombardozzy as Mustang, Wesley MacInnes as Dante Ferstel",
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            MoviesDetailResponse(
                7,
                "Fantastic Beasts: The Crimes of Grinderwald",
                "2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "David Yates",
                "J.K Rowling",
                "$200,000,000.00",
                "$653,355,901.00",
                "Eddie Redmayne as Newt Scamander, Katherine Waterston as Porpentina Goldstein, Alison Sudol as Queenie Goldstein, Johny Depp as Gellert Grinderwald, Jude Law as Albus Dumbledore, Dan Fogler as Jacob Kowalski, Ezra Miller as Credence Barebone, Zoe Kravitz as Leta Lestrange, Callum Turner as Theseus Scamander",
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MoviesDetailResponse(
                8,
                "How To Train Your Dragon",
                "2010",
                "Fantasy, Adventure, Animation, Family",
                "1h 40m",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "M. Night Shyamalan",
                "M. Night Shyamalan",
                "$165,000,000.00",
                "$494,878,759.00",
                "Jay Baruchel as Hiccup Horrendous Haddock III, Gerard Butler as Stoick the Vast, Craig Ferguson as Gobber the Belch, America Ferrera as Astrid Hofferson, Jonah Hill as Snotlout Jorgenson, Christopher Mintz-Plasse as Fishlegs Ingerman, T.J Miller as Tuffnut Thorston, Kristen Wiig as Ruffnut Thorston, David Tennant as Spitelout",
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MoviesDetailResponse(
                9,
                "Avengers: Infinity War",
                "2018",
                "Adventure, Action, Science Fiction",
                "2h 29m",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "Anthony Russo and Joe Russo",
                "Christopher Markus",
                "$300,000,000.00",
                "$2,046,239,637.00",
                "Robert Downey Jr. as Tonu Stark / Iron Man, Chris Hemsworth as Thor Odinson, Chris Evans as Steve Rogers / Captain America, Scarlett Johansson as Natasha Romanoff / Black Widow, Benedict Cumberbatch as Stephen Strange / Dr. Strange, Tom Holland as Peter Parker / Spiderman, Chadwich Boseman as T`Challa / Black Panther, Don Cheadle as James Rhodes / War Machine, Zoe Saldana as Gamora",
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            MoviesDetailResponse(
                10,
                "Glass",
                "2019",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "M. Night Shyamalan",
                "M. Night Shyamalan",
                "$20,000,000.00",
                "$246,941,965.00",
                "James McAvoy as Patricia / Dennis / Hedwig / The Beast / Barry / Heinrich / Jade / Ian / Mary Reynolds / Norma / Jalin / Kat / B.T. / Kevin Wendell Crumb / Mr. Pritchard / Felida / Luke / Goddard / Samuel / Polly, Bruce Willis as David Dunn / The Overseer, Anna Taylor-Joy as Casey Cooke, Sarah Paulson as Dr. Ellie Staple, Samuel L. Jackson as Elijah Price / Mr. Glass, William Turner as Young Elijah, Johnny Hiram Jamison as 13 years old Elijah, Owen Vitulo as 8 years old Kevin, Colin Becker as 10 years old David",
                R.drawable.poster_glass
            )
        )

        return movies
    }

    fun generateAllMoviesDataDummy(): List<MoviesResponse> {
        val movies = ArrayList<MoviesResponse>()

        movies.add(
            MoviesResponse(
                1,
                "Alita: Battle Angel",
                "2019",
                "Science Fiction, Action, Adventure",
                R.drawable.poster_alita
            )
        )
        movies.add(
            MoviesResponse(
                2,
                "Aquaman",
                "2018",
                "Fantasy, Action, Adventure",
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MoviesResponse(
                3,
                "Bohemian Rhapsody",
                "2018",
                "Drama, Music",
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MoviesResponse(
                4,
                "Creed II",
                "2018",
                "Drama",
                R.drawable.poster_creed
            )
        )
        movies.add(
            MoviesResponse(
                5,
                "A Star Is Born",
                "2018",
                "Drama, Romance, Music",
                R.drawable.poster_a_start_is_born
            )
        )
        movies.add(
            MoviesResponse(
                6,
                "Cold Pursuit",
                "2019",
                "Action, Crime, Thriller",
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            MoviesResponse(
                7,
                "Fantastic Beasts: The Crimes of Grinderwald",
                "2018",
                "Adventure, Fantasy, Drama",
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MoviesResponse(
                8,
                "How To Train Your Dragon",
                "2010",
                "Fantasy, Adventure, Animation, Family",
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MoviesResponse(
                9,
                "Avengers: Infinity War",
                "2018",
                "Adventure, Action, Science Fiction",
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            MoviesResponse(
                10,
                "Glass",
                "2019",
                "Thriller, Drama, Science Fiction",
                R.drawable.poster_glass
            )
        )

        return movies
    }

    fun generateTvShowsDetailDataDummy(): List<TvShowsDetailResponse> {
        val tvShows = ArrayList<TvShowsDetailResponse>()

        tvShows.add(
            TvShowsDetailResponse(
                1,
                "Arrow",
                "2012",
                "Action, Adventure, Drama, Mystery, Crime",
                "42m",
                "Greg Berlanti, Marc Guggenheim, and Andrew Kreisberg",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Stephen Amell as Oliver Queen / Green Arrow, David Ramsey as John Diggle / Spartan, Emily Bett Rickards as Felicity Smoak, Katie Cassidy as Black Siren, Willa Holland as Thea Queen / Speedy, Paul Backthorner as Quentin Lance, Rick Gonzales as Rene Ramirez / Wild Dog, John Barrowman as Malcom Merylin, Juliana Harkavy as Dinah Drake / Black Canary",
                R.drawable.poster_arrow
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                2,
                "Doom Patrol",
                "2019",
                "Action, Adventure, Comedy, Sci-Fi, Fantasy",
                "49m",
                "Jeremy Carver",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Diane Guerrero as Crazy Jane, April Bowlby as Rita Farr / Elasti-Woman, Joivan Wade as Victor Stone / Cyborg, Matt Bomer as Larry Trainor / Negative Man, Brendan Fraser as Cliff Steele / Robotman, Timothy Dalton as Dr. Niles Caulder / The Chief, Riley Shanahan as Cliff Steele / Robotman, Matthew Zuk as Larry Trainor / Negative Man, Alan Tudyk as Mr. Nobody",
                R.drawable.poster_doom_patrol
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                3,
                "The Flash",
                "2014",
                "Drama, Sci-Fi, Fantasy",
                "44m",
                "Greg Berlanti, Geoff Johns, and Andrew Kreisberg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Grang Gustin as Barry Allen / The Flash, Carlos Valdes as Cisco Ramon / Echo, Danielle Panabaker as Killer Frost / Caitlin Snow, Candice Patton as Iris West-Allen / Millie Foss, Jesse L. Martin as Joe West, Tom Cavanagh as Harrison Wells / Pariah, Danielle Nicolet as Cecile Horton, Hartley Sawyer as Ralph Dibny / Elongated Man, Keiynan Lonsdale as Wally West / Kid Flash",
                R.drawable.poster_flash
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                4,
                "The Walking Dead",
                "2010",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                "42m",
                "Frank Darabont",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "Andrew Lincoln as Rick Grimes, Christian Serratos as Rosita Espinosa, Chandler Riggs as Carl Grimes, Josh McDermitt as Eugene Porter, Steve Yeun as Glenn Rhee, Norman Reedus as Daryl Dixon, Melissa McBride as Carol Peletier, Lauren Cohan as Maggie Greene, Danai Gurira as Michonne",
                R.drawable.poster_the_walking_dead
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                5,
                "The Umbrella Academy",
                "2019",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                "55m",
                "Steve Blackman",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "Tom Hopper as Luther Hargreeves, David Castaneda as Diego Hargreeves, Emmy Raver-Lampman as Allison Hargreeves, Robert Sheehan as Klaus Hargreeves, Aidan Gallagher as Number Five, Elliot Page as Vanya Hargreeves, Kate Walsh as The Handler, Colm Feore as Sir Reginald Hargreeves, Justin H. Min as Ben Hargreeves",
                R.drawable.poster_the_umbrella
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                6,
                "Money Heist",
                "2017",
                "Crime, Drama",
                "1h 10m",
                "Alex Pina",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "Ursula Corbero as Tokyo, Alvaro Morte as El Profesor, Itziar Ituno as Raquel Murillo / Lisbon, Pedro Alonso as Berlin, Albes Flores as Nairobi, Miguel Herran as Rio, Jaime Lorente as Denver, Esther Acebo as Monica Gaztambide / Stockholm, Enrique Arce as Arturo Roman",
                R.drawable.poster_money_heist
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                7,
                "Marvel's Iron Fist",
                "2017",
                "Action, Adventure, Sci-Fi, Fantasy, Drama",
                "55m",
                "Scott Buck",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "Finn Jones as Danny Rand, Jessica Henwick as Colleen Wing, Jessica Stroup as Joy Meachum, Tom Pelphrey as Ward Meachum, Sacha Dhawan as Davos, Rosario Dawson as Claire Temple, David Wenham as Harold Meachum, Alice Eve as Mary Walker, Ching Hoh-Wai as Madame Gao",
                R.drawable.poster_iron_fist
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                8,
                "Supernatural",
                "2005",
                "Mystery, Sci-Fi, Fantasy, Drama",
                "45m",
                "Eric Kripke",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "Jensen Ackles as Dean Winchester, Jared Padalecki as Sam Winchester, Alexander Calvert as Belphegor / Jack, Samantha Ferris as Ellen Harvelle, Emily Swallow as Amara / Karin, Misha Collins as Lucifer / Castiel, Richard Speight Jr. as Trickester / Gabriel, Genevieve Padalecki as Ruby / Genevive Padalecki, Curtis Amstrong as Metatron",
                R.drawable.poster_supernatural
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                9,
                "Supergirl",
                "2015",
                "Action, Sci-Fi, Adventure, Drama",
                "42m",
                "Greg Berlanti, Ali Adler, Andrew Kreisberg",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "David Harewood as Cyborg Spiderman / Martian Manhunter, Meliisa Benoist as Kara Danvers / Supergirl, Chyler Leight as Alex Danvers, Mehcad Brooks as James Olsen / Guardian, Katie McGrath as Lena Luthor, Jeremy Jordan as Winn Schoot / Toyman, Jesse Rath as Querl Dox / Braniac-5, Chris Wood as Mon-El, Andrea Brooks as Eve Teschmacher / Hope",
                R.drawable.poster_supergirl
            )
        )
        tvShows.add(
            TvShowsDetailResponse(
                10,
                "Hanna",
                "2019",
                "Action, Adventure, Drama",
                "50m",
                "David Farr",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "Esme Creed-Miles as Hanna, Mireille Enos as Marissa, Noah Taylor as Dr. Roland Kunek, Joel Kinnaman as Erik Heller, Anthony Welsh as Leo Garner, Cherrrele Skeete as Terri Miller, Dermot Mulroney as Carmichael, Yasmin Monet Prince as Clara Mahan, Aine Rose Daly as Trainer 242 / Sandy Phillips",
                R.drawable.poster_hanna
            )
        )

        return tvShows
    }

    fun generateAllTvShowsDataDummy(): List<TvShowsResponse> {
        val tvShows = ArrayList<TvShowsResponse>()

        tvShows.add(
            TvShowsResponse(
                1,
                "Arrow",
                "2012",
                "Action, Adventure, Drama, Mystery, Crime",
                R.drawable.poster_arrow
            )
        )
        tvShows.add(
            TvShowsResponse(
                2,
                "Doom Patrol",
                "2019",
                "Action, Adventure, Comedy, Sci-Fi, Fantasy",
                R.drawable.poster_doom_patrol
            )
        )
        tvShows.add(
            TvShowsResponse(
                3,
                "The Flash",
                "2014",
                "Drama, Sci-Fi, Fantasy",
                R.drawable.poster_flash
            )
        )
        tvShows.add(
            TvShowsResponse(
                4,
                "The Walking Dead",
                "2010",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                R.drawable.poster_the_walking_dead
            )
        )
        tvShows.add(
            TvShowsResponse(
                5,
                "The Umbrella Academy",
                "2019",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                R.drawable.poster_the_umbrella
            )
        )
        tvShows.add(
            TvShowsResponse(
                6,
                "Money Heist",
                "2017",
                "Crime, Drama",
                R.drawable.poster_money_heist
            )
        )
        tvShows.add(
            TvShowsResponse(
                7,
                "Marvel's Iron Fist",
                "2017",
                "Action, Adventure, Sci-Fi, Fantasy, Drama",
                R.drawable.poster_iron_fist
            )
        )
        tvShows.add(
            TvShowsResponse(
                8,
                "Supernatural",
                "2005",
                "Mystery, Sci-Fi, Fantasy, Drama",
                R.drawable.poster_supernatural
            )
        )
        tvShows.add(
            TvShowsResponse(
                9,
                "Supergirl",
                "2015",
                "Action, Sci-Fi, Adventure, Drama",
                R.drawable.poster_supergirl
            )
        )
        tvShows.add(
            TvShowsResponse(
                10,
                "Hanna",
                "2019",
                "Action, Adventure, Drama",
                R.drawable.poster_hanna
            )
        )

        return tvShows
    }


    /**
     * simulation data local
     */

    fun generateAllMoviesFavoriteDataDummy(): List<MoviesEntity> {
        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
                1,
                "Alita: Battle Angel",
                "2019",
                "Science Fiction, Action, Adventure",
                R.drawable.poster_alita
            )
        )
        movies.add(
            MoviesEntity(
                2,
                "Aquaman",
                "2018",
                "Fantasy, Action, Adventure",
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MoviesEntity(
                3,
                "Bohemian Rhapsody",
                "2018",
                "Drama, Music",
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MoviesEntity(
                4,
                "Creed II",
                "2018",
                "Drama",
                R.drawable.poster_creed
            )
        )
        movies.add(
            MoviesEntity(
                5,
                "A Star Is Born",
                "2018",
                "Drama, Romance, Music",
                R.drawable.poster_a_start_is_born
            )
        )
        movies.add(
            MoviesEntity(
                6,
                "Cold Pursuit",
                "2019",
                "Action, Crime, Thriller",
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            MoviesEntity(
                7,
                "Fantastic Beasts: The Crimes of Grinderwald",
                "2018",
                "Adventure, Fantasy, Drama",
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MoviesEntity(
                8,
                "How To Train Your Dragon",
                "2010",
                "Fantasy, Adventure, Animation, Family",
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MoviesEntity(
                9,
                "Avengers: Infinity War",
                "2018",
                "Adventure, Action, Science Fiction",
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            MoviesEntity(
                10,
                "Glass",
                "2019",
                "Thriller, Drama, Science Fiction",
                R.drawable.poster_glass
            )
        )

        return movies
    }

    fun generateMoviesDetailFavoriteDataDummy(): List<MoviesDetailEntity> {
        val movies = ArrayList<MoviesDetailEntity>()

        movies.add(
            MoviesDetailEntity(
                1,
                "Alita: Battle Angel",
                "2019",
                "Science Fiction, Action, Adventure",
                "2h 2m",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "Robert Rodriguez",
                "Laeta Kalogridis and James Cameron",
                "$170,000,000.00",
                "$404,852,543.00",
                "Rosa Salazar as Alita, Christoph Waltz as Dr. Dyson Ido, Jennifer Connelly as Chiren, Mahershala Ali as Vector, Ed Skrein as Zapan, Jackie Earle Haley as Grewishka, Keean Johnson as Hugo, Lana Condor as Koyomi, Jorge Lenderborg Jr. as Tanji",
                R.drawable.poster_alita
            )
        )
        movies.add(
            MoviesDetailEntity(
                2,
                "Aquaman",
                "2018",
                "Fantasy, Action, Adventure",
                "2h 24m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "James Wan",
                "Will Beall and David Leslie Johnson-McGoldrick",
                "$160,000,000.00",
                "$1,148,461,807.00",
                "Jason Momoa as Arthur Curry / Aquaman, Amber Heard as Mera, Willem Dafoe as Nuidis Vulko, Patrick Wilson as King Orm Marius / Ocean Master, Nicole Kidman as Atlanna, Dolph Lundgren as King Nereus, Yahya Abdul-Mateen II as David Kane / Black Manta, Temuerra Morrison as Thomas Curry, Ludi Lin as Captain Murk",
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MoviesDetailEntity(
                3,
                "Bohemian Rhapsody",
                "2018",
                "Drama, Music",
                "2h 15m",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "Bryan Singer",
                "Anthonu McCarten",
                "$52,000,000.00",
                "$894,027,543.00",
                "Rami Malek as Freddie Mercury, Gwilym Lee as Brian May, Ben Hardy as Roger Taylor, Joseph Mazzelo as John Deacon, Lucy Boynton as Mary Austin, Aidan Gillen as John Reid, Allen Leech as Paul Prenter, Tom Hollander as Jim Beach, Mike Myers as Ray Foster",
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MoviesDetailEntity(
                4,
                "Creed II",
                "2018",
                "Drama",
                "2h 10m",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "Steven Caple Jr.",
                "Sylvester Stallone and Juel Taylor",
                "$50,000,000.00",
                "$214,215,889.00",
                "Michael B. Jordan as Adonis Creed, Sylvester Stallone as Robert Balboa Sr., Dolph Lundgreen as Ivan Drago, Florian Munteanu as Viktor Drago, Tessa Thompson as Bianca Taylor, Wood Harris as Tony Evers, Phylicia Rashad as Mary Anne Creed, Andre Ward as Danny Wheeler, Brigitte Nielsen as Ludmilla Drago",
                R.drawable.poster_creed
            )
        )
        movies.add(
            MoviesDetailEntity(
                5,
                "A Star Is Born",
                "2018",
                "Drama, Romance, Music",
                "2h 16m",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "Bradley Cooper",
                "Bradley Cooper, Will Fetters, and Eric Roth",
                "$36,000,000.00",
                "$433,888,866.00",
                "Bradley Cooper as Jackson Maine, Lady Gaga as Ally Campana, Sam Elliot as Bobby Maine, Andrew Dice Clay as Lorenzo Campana, Rafi Gavron as Rez Gavron, Anthony Ramos as Ramon, Dave Chappelle as George Stone, Marlon Williams as Himself, Brandy Carlile as Herself",
                R.drawable.poster_a_start_is_born
            )
        )
        movies.add(
            MoviesDetailEntity(
                6,
                "Cold Pursuit",
                "2019",
                "Action, Crime, Thriller",
                "1h 59m",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "Hans Petter Moland",
                "Frank Baldwin",
                "$60,000,000.00",
                "$76,419,755.00",
                "Liam Neeson as Nels Coxman, Laura Dern as Grace Coxman, Emmy Rossum as Kim Dash, Michale Eklund as Steve Milliner, Micheal Richardson as Kyle Coxman, Bradley Stryker as Jacon Rutman, Tom Bateman as Trevor Calcote, Domenick Lombardozzy as Mustang, Wesley MacInnes as Dante Ferstel",
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            MoviesDetailEntity(
                7,
                "Fantastic Beasts: The Crimes of Grinderwald",
                "2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "David Yates",
                "J.K Rowling",
                "$200,000,000.00",
                "$653,355,901.00",
                "Eddie Redmayne as Newt Scamander, Katherine Waterston as Porpentina Goldstein, Alison Sudol as Queenie Goldstein, Johny Depp as Gellert Grinderwald, Jude Law as Albus Dumbledore, Dan Fogler as Jacob Kowalski, Ezra Miller as Credence Barebone, Zoe Kravitz as Leta Lestrange, Callum Turner as Theseus Scamander",
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MoviesDetailEntity(
                8,
                "How To Train Your Dragon",
                "2010",
                "Fantasy, Adventure, Animation, Family",
                "1h 40m",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "M. Night Shyamalan",
                "M. Night Shyamalan",
                "$165,000,000.00",
                "$494,878,759.00",
                "Jay Baruchel as Hiccup Horrendous Haddock III, Gerard Butler as Stoick the Vast, Craig Ferguson as Gobber the Belch, America Ferrera as Astrid Hofferson, Jonah Hill as Snotlout Jorgenson, Christopher Mintz-Plasse as Fishlegs Ingerman, T.J Miller as Tuffnut Thorston, Kristen Wiig as Ruffnut Thorston, David Tennant as Spitelout",
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MoviesDetailEntity(
                9,
                "Avengers: Infinity War",
                "2018",
                "Adventure, Action, Science Fiction",
                "2h 29m",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "Anthony Russo and Joe Russo",
                "Christopher Markus",
                "$300,000,000.00",
                "$2,046,239,637.00",
                "Robert Downey Jr. as Tonu Stark / Iron Man, Chris Hemsworth as Thor Odinson, Chris Evans as Steve Rogers / Captain America, Scarlett Johansson as Natasha Romanoff / Black Widow, Benedict Cumberbatch as Stephen Strange / Dr. Strange, Tom Holland as Peter Parker / Spiderman, Chadwich Boseman as T`Challa / Black Panther, Don Cheadle as James Rhodes / War Machine, Zoe Saldana as Gamora",
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            MoviesDetailEntity(
                10,
                "Glass",
                "2019",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "M. Night Shyamalan",
                "M. Night Shyamalan",
                "$20,000,000.00",
                "$246,941,965.00",
                "James McAvoy as Patricia / Dennis / Hedwig / The Beast / Barry / Heinrich / Jade / Ian / Mary Reynolds / Norma / Jalin / Kat / B.T. / Kevin Wendell Crumb / Mr. Pritchard / Felida / Luke / Goddard / Samuel / Polly, Bruce Willis as David Dunn / The Overseer, Anna Taylor-Joy as Casey Cooke, Sarah Paulson as Dr. Ellie Staple, Samuel L. Jackson as Elijah Price / Mr. Glass, William Turner as Young Elijah, Johnny Hiram Jamison as 13 years old Elijah, Owen Vitulo as 8 years old Kevin, Colin Becker as 10 years old David",
                R.drawable.poster_glass
            )
        )

        return movies
    }

    fun generateTvShowsDetailFavoriteDataDummy(): List<TvShowsDetailEntity> {
        val tvShows = ArrayList<TvShowsDetailEntity>()

        tvShows.add(
            TvShowsDetailEntity(
                1,
                "Arrow",
                "2012",
                "Action, Adventure, Drama, Mystery, Crime",
                "42m",
                "Greg Berlanti, Marc Guggenheim, and Andrew Kreisberg",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Stephen Amell as Oliver Queen / Green Arrow, David Ramsey as John Diggle / Spartan, Emily Bett Rickards as Felicity Smoak, Katie Cassidy as Black Siren, Willa Holland as Thea Queen / Speedy, Paul Backthorner as Quentin Lance, Rick Gonzales as Rene Ramirez / Wild Dog, John Barrowman as Malcom Merylin, Juliana Harkavy as Dinah Drake / Black Canary",
                R.drawable.poster_arrow
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                2,
                "Doom Patrol",
                "2019",
                "Action, Adventure, Comedy, Sci-Fi, Fantasy",
                "49m",
                "Jeremy Carver",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "Diane Guerrero as Crazy Jane, April Bowlby as Rita Farr / Elasti-Woman, Joivan Wade as Victor Stone / Cyborg, Matt Bomer as Larry Trainor / Negative Man, Brendan Fraser as Cliff Steele / Robotman, Timothy Dalton as Dr. Niles Caulder / The Chief, Riley Shanahan as Cliff Steele / Robotman, Matthew Zuk as Larry Trainor / Negative Man, Alan Tudyk as Mr. Nobody",
                R.drawable.poster_doom_patrol
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                3,
                "The Flash",
                "2014",
                "Drama, Sci-Fi, Fantasy",
                "44m",
                "Greg Berlanti, Geoff Johns, and Andrew Kreisberg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Grang Gustin as Barry Allen / The Flash, Carlos Valdes as Cisco Ramon / Echo, Danielle Panabaker as Killer Frost / Caitlin Snow, Candice Patton as Iris West-Allen / Millie Foss, Jesse L. Martin as Joe West, Tom Cavanagh as Harrison Wells / Pariah, Danielle Nicolet as Cecile Horton, Hartley Sawyer as Ralph Dibny / Elongated Man, Keiynan Lonsdale as Wally West / Kid Flash",
                R.drawable.poster_flash
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                4,
                "The Walking Dead",
                "2010",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                "42m",
                "Frank Darabont",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "Andrew Lincoln as Rick Grimes, Christian Serratos as Rosita Espinosa, Chandler Riggs as Carl Grimes, Josh McDermitt as Eugene Porter, Steve Yeun as Glenn Rhee, Norman Reedus as Daryl Dixon, Melissa McBride as Carol Peletier, Lauren Cohan as Maggie Greene, Danai Gurira as Michonne",
                R.drawable.poster_the_walking_dead
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                5,
                "The Umbrella Academy",
                "2019",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                "55m",
                "Steve Blackman",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "Tom Hopper as Luther Hargreeves, David Castaneda as Diego Hargreeves, Emmy Raver-Lampman as Allison Hargreeves, Robert Sheehan as Klaus Hargreeves, Aidan Gallagher as Number Five, Elliot Page as Vanya Hargreeves, Kate Walsh as The Handler, Colm Feore as Sir Reginald Hargreeves, Justin H. Min as Ben Hargreeves",
                R.drawable.poster_the_umbrella
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                6,
                "Money Heist",
                "2017",
                "Crime, Drama",
                "1h 10m",
                "Alex Pina",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "Ursula Corbero as Tokyo, Alvaro Morte as El Profesor, Itziar Ituno as Raquel Murillo / Lisbon, Pedro Alonso as Berlin, Albes Flores as Nairobi, Miguel Herran as Rio, Jaime Lorente as Denver, Esther Acebo as Monica Gaztambide / Stockholm, Enrique Arce as Arturo Roman",
                R.drawable.poster_money_heist
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                7,
                "Marvel's Iron Fist",
                "2017",
                "Action, Adventure, Sci-Fi, Fantasy, Drama",
                "55m",
                "Scott Buck",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "Finn Jones as Danny Rand, Jessica Henwick as Colleen Wing, Jessica Stroup as Joy Meachum, Tom Pelphrey as Ward Meachum, Sacha Dhawan as Davos, Rosario Dawson as Claire Temple, David Wenham as Harold Meachum, Alice Eve as Mary Walker, Ching Hoh-Wai as Madame Gao",
                R.drawable.poster_iron_fist
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                8,
                "Supernatural",
                "2005",
                "Mystery, Sci-Fi, Fantasy, Drama",
                "45m",
                "Eric Kripke",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "Jensen Ackles as Dean Winchester, Jared Padalecki as Sam Winchester, Alexander Calvert as Belphegor / Jack, Samantha Ferris as Ellen Harvelle, Emily Swallow as Amara / Karin, Misha Collins as Lucifer / Castiel, Richard Speight Jr. as Trickester / Gabriel, Genevieve Padalecki as Ruby / Genevive Padalecki, Curtis Amstrong as Metatron",
                R.drawable.poster_supernatural
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                9,
                "Supergirl",
                "2015",
                "Action, Sci-Fi, Adventure, Drama",
                "42m",
                "Greg Berlanti, Ali Adler, Andrew Kreisberg",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "David Harewood as Cyborg Spiderman / Martian Manhunter, Meliisa Benoist as Kara Danvers / Supergirl, Chyler Leight as Alex Danvers, Mehcad Brooks as James Olsen / Guardian, Katie McGrath as Lena Luthor, Jeremy Jordan as Winn Schoot / Toyman, Jesse Rath as Querl Dox / Braniac-5, Chris Wood as Mon-El, Andrea Brooks as Eve Teschmacher / Hope",
                R.drawable.poster_supergirl
            )
        )
        tvShows.add(
            TvShowsDetailEntity(
                10,
                "Hanna",
                "2019",
                "Action, Adventure, Drama",
                "50m",
                "David Farr",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "Esme Creed-Miles as Hanna, Mireille Enos as Marissa, Noah Taylor as Dr. Roland Kunek, Joel Kinnaman as Erik Heller, Anthony Welsh as Leo Garner, Cherrrele Skeete as Terri Miller, Dermot Mulroney as Carmichael, Yasmin Monet Prince as Clara Mahan, Aine Rose Daly as Trainer 242 / Sandy Phillips",
                R.drawable.poster_hanna
            )
        )

        return tvShows
    }

    fun generateAllTvShowsFavoriteDataDummy(): List<TvShowsEntity> {
        val tvShows = ArrayList<TvShowsEntity>()

        tvShows.add(
            TvShowsEntity(
                1,
                "Arrow",
                "2012",
                "Action, Adventure, Drama, Mystery, Crime",
                R.drawable.poster_arrow
            )
        )
        tvShows.add(
            TvShowsEntity(
                2,
                "Doom Patrol",
                "2019",
                "Action, Adventure, Comedy, Sci-Fi, Fantasy",
                R.drawable.poster_doom_patrol
            )
        )
        tvShows.add(
            TvShowsEntity(
                3,
                "The Flash",
                "2014",
                "Drama, Sci-Fi, Fantasy",
                R.drawable.poster_flash
            )
        )
        tvShows.add(
            TvShowsEntity(
                4,
                "The Walking Dead",
                "2010",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                R.drawable.poster_the_walking_dead
            )
        )
        tvShows.add(
            TvShowsEntity(
                5,
                "The Umbrella Academy",
                "2019",
                "Acion, Adventure, Drama, Sci-Fi, Fantasy",
                R.drawable.poster_the_umbrella
            )
        )
        tvShows.add(
            TvShowsEntity(
                6,
                "Money Heist",
                "2017",
                "Crime, Drama",
                R.drawable.poster_money_heist
            )
        )
        tvShows.add(
            TvShowsEntity(
                7,
                "Marvel's Iron Fist",
                "2017",
                "Action, Adventure, Sci-Fi, Fantasy, Drama",
                R.drawable.poster_iron_fist
            )
        )
        tvShows.add(
            TvShowsEntity(
                8,
                "Supernatural",
                "2005",
                "Mystery, Sci-Fi, Fantasy, Drama",
                R.drawable.poster_supernatural
            )
        )
        tvShows.add(
            TvShowsEntity(
                9,
                "Supergirl",
                "2015",
                "Action, Sci-Fi, Adventure, Drama",
                R.drawable.poster_supergirl
            )
        )
        tvShows.add(
            TvShowsEntity(
                10,
                "Hanna",
                "2019",
                "Action, Adventure, Drama",
                R.drawable.poster_hanna
            )
        )

        return tvShows
    }

}