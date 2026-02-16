<p>You are given a string <code>s</code> consisting only of the characters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</p>

<p>A <strong><span data-keyword="substring-nonempty">substring</span></strong> of <code>s</code> is called <strong>balanced</strong> if all <strong>distinct</strong> characters in the <strong>substring</strong> appear the <strong>same</strong> number of times.</p>

<p>Return the <strong>length of the longest balanced substring</strong> of <code>s</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "abbac"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The longest balanced substring is <code>"abba"</code> because both distinct characters <code>'a'</code> and <code>'b'</code> each appear exactly 2 times.</p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "aabcc"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The longest balanced substring is <code>"abc"</code> because all distinct characters <code>'a'</code>, <code>'b'</code> and <code>'c'</code> each appear exactly 1 time.</p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "aba"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>One of the longest balanced substrings is <code>"ab"</code> because both distinct characters <code>'a'</code> and <code>'b'</code> each appear exactly 1 time. Another longest balanced substring is <code>"ba"</code>.</p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> contains only the characters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</li> 
</ul>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>前缀和</li></div></div><br><div><li>👍 28</li><li>👎 0</li></div>