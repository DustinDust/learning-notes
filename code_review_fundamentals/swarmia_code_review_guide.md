<!-- markdownlint-disable MD013-->

# Swarmia Code Review Guide

This is comprehensive guide for code reviewing from swarmia.com.

## Why do we need code review?

- Sharing knowledge: the depth of know-how shared depends on the thoroughness of the review, but some amount of information is always shared. Knoweledge shared can be general tips about the tech & some specific project or domain knowledge.
- Spreading ownership: improve mutual code ownership by having multiple people look at the code and identify potential issues.
- Unifying development practices in the team: code review is a way to ensure that everyone is following the same development practices and that the code is consistent.
- Quality Control: While they help catch defects, their greater value lies in identifying software design issues while they are still easy to modify

## Adopting code reviews

Successful adoption requires more than just technical tools

- It requires team agreement on philosophy and motivation. To reduce friction, every team member should contribute to the decision-making process regarding how reviews will be conducted
- A critical component is communication—teams must educate themselves on how to give feedback respectfully, focusing on the code rather than the author and maintaining a positive, innovative atmosphere through techniques like "Yes, and..."

## Best Practices

1. Decide on a process. This should be for the responsibility to bounce between the reviewers and reviewees. The more explicit the process is, the less likely the ball is dropped by any party.

- Example:

![Example process](https://www.swarmia.com/static/7f4cb271fee404dddb876c0598c213e2/da8b6/pr-process-sketch.png)

2. Focus on the right things

It's a good idea to have guidelines for what to focus on in a code reviews. Here's the recommendations:

- Functionality: Does the code behave as the PR author inteneded or as users would expect?
- Software design: Is the code well-designed and fitted to the surrounding architecture?
- Complexity: Is the code simple easy to maintain
- Tests: Are the tests comprehensive and well-designed?
- Naming: Are the names descriptive?
- Comments: Are the comments clear and useful?
- Documentation: Is the documentation up-to-date?

3. Discuss the high-level approach early

- Before coding a complext feature, it'll be beneficial to discuss the high-level approach first. Should be done when planning the feature
- Don't end up rewriting the PR after reviewing just because the approach wasn't discussed beforehand.
- Sometimes proof-of-concept implementation is needed to ignite the discussion. Open draft PR of the approach and make architecture decisions there.

4. Optimize for the team

- This one is best explained by Google's engineering practices documents:

  > We optimize for the speed at which a team of developers can produce a product together, as opposed to optimizing for the speed at which an individual developer can write code.

5. Default to action

- Sometimes reviews can stall for several reasons, which might lead to blocking progress. One can approve a PR even if there's some input left for the author to consider.
- Even though the PR isn't perfect, developers should be inclined to merge code instead of primarily focusing on poking holes in the implementation.

6. Keep pull request small

- Smaller batches are easier to design, test, review and merge!
- Google recommendations:

  > There are no hard and fast rules about how large is “too large.” 100 lines is usually a reasonable size for a CL, and 1000 lines is usually too large, but it’s up to the judgment of your reviewer. The number of files that a change is spread across also affects its “size.” A 200-line change in one file might be okay, but spread across 50 files it would usually be too large.

7. Foster a positive feedback culture

- Give feedback about the code, not about the author.
- Pick your battles.
- Accept that there are multiple correct solutions to a problem.
- You’re in the same boat.
- PR authors are humans with feelings (except dependabot 🤖).
- Provide reasons, not feelings, to support your position.
- Use the “Yes, and...” technique to keep an innovative atmosphere. It can be an ungracious pattern to dismiss fresh and fragile ideas in a draft PR stage.
- Keep the feedback balanced with positive comments. It’s always delightful to receive praise from a reviewer.

8. Use continuous integration effectively

- Github actions and status checks are widely used for building CI pipelines. We should use them to automate as many checks as possible
- Automated allow reviewers to focus on more important things such as software design, architecture, and readability.
- Checks can include tests, test coverage, code style, commit message conventions, and more.

9. Delegate nit-picking to a computer

- Automatic checks will always be enforced, while the human process relies on the reviewers' memories to reject and anti-pattern
- Examples such as ESLint rules, code formatting

10. Communicate explicitly

- When reviewing, be explicit about the action you request from the author.
  - What do you want them to do as a result of you feedback?
- Tip for the PR author: dismissing a review resets the pull request state to indicate that the reviewer can review again. It’s up to you, the PR author, to decide if it feels important enough to use the feature, but especially in remote teams, it might help to make the process even more explicit.

11. Use explicit review requests

- In github, we can request certain people to review a PR. It's a convinient way to let people know your request is ready
- We can automate this by setting up `CODEOWNERS` file.

12. Review your own code

13. Document as much as possible

- When receiving a comment suggestion, aim for documenting the discussion in code. This'll the next maintainer understand the code without reading the PR discussions
- In some case, author can even copy-paste their PR discussion response as a comment in the code

14. Write clear PR discussion

- The reviewer forms a mental picture of a pull request from multiple information sources: feature planning, description in the issue tracker, PR description, commit messages, chat history, etc. The more coherent a picture is, the faster the review process.
- The PR should fill the technical gap between the story ticket (Jira, Shortcut) didn't cover
- Visual Demo is always a nice touch
- Balance between explaining nothing or explaining everything

15. Use the shared repository model

For most private repositories, Swarmia recommend starting with the Shared repository model:

> In the shared repository model, collaborators are granted push access to a single shared repository and topic branches are created when changes need to be made.

16. Keep discussion public

- To be more mindful of colleagues working remotely, it's polite to add a summary of face-to-face discussions
- PR discussion should be searchable and easily accessible for developers. They act as a history log of discussion which might be incredibly valuable when debugging a production incident later on.

17. Swarmia advertising
