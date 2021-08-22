<div align="center">
<img src="https://i.imgur.com/xbCTqv9.gif" alt="board gif"/><br/>
<br/>
<b>The classic tic-tac-toe game with AI, built with Java's Swing.</b>
</div>
<br/>
<p>The AI comes in three difficulties: easy, medium, and hard.<br/> 
The hard AI can't lose; it will either win or get a draw.</p>

<h3>Available Modes:</h3>
<ul>
<li>Human vs Human</li>
<li>Human vs AI</li>
<li>AI vs AI</li>
</ul>

<h3>AI Difficulties:</h3>
<ul>
<li><a href="#easy">Easy</a></li>
<li><a href="#medium">Medium</a></li>
<li><a href="#hard">Hard</a></li>
</ul>

<h3>Install:</h3>
<p>Download the executable .jar file or compile the source coude and run the Main class.</p>

<hr />

<h2 id="easy">Easy AI</h2>
<p>The easy AI is very simple. It will randomly generate x and y coordinates and pick a cell.</p>


<h2 id="medium">Medium AI</h2>
<p>The medium AI works the same as the easy AI <em>unless</em> there's a potential game-ending move <br/>(either a move that ends in a win or a move that prevents the opponent's win). If there is, the medium AI will make that move.</p>

<h2 id="hard">Hard AI</h2>
<p>The hard AI implements the <a href="https://en.wikipedia.org/wiki/Minimax" target="_blank">Minimax</a> algorithm. It will loop over the empty cells and simulate future moves, picking the one that grants the best outcome.</p>